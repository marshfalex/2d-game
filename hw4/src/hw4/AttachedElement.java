package hw4;

import java.util.ArrayList;
import api.AbstractElement;

/**
 * An attached element is one that is associated with another "base" element
 * such as a PlatformElement or a LiftElement. Specifically, the attached
 * element's movement is determined by the movement of the base element, the
 * element always remains a fixed distance away.
 * 
 * @author Marshall Alexander
 * @see PlatformElement
 * @see api.AbstractElement
 */

public class AttachedElement extends PlatformElement {

    /**
     * min y-coordinate
     */
    private int min;

    /**
     * max y-coordinate
     */
    private int max;

    /**
     * list of associated elements
     */
    private ArrayList<AbstractElement> associatedElements;

    /**
     * base element
     */
    private AbstractElement base;

    /**
     * initial x-coordinate offset
     */
    private int initialOffset;

    /**
     * Constructs a new AttachedElement. Before being added to an associated "base"
     * element such as a PlatformElement or LiftElement, the x and y coordinates are
     * initialized to zero. When the base object is set (not in this constructor),
     * the x-coordinate will be calculated as the base object's x-coordinate, plus
     * the given offset, and the y-coordinate will become the base object's
     * y-coordinate, minus this element's height, minus the hover amount.
     * 
     * @param width  element's width
     * @param height element's height
     * @param offset when added to a base object, this amount will be added to the
     *               other object's x-coordinate to calculate this element's
     *               x-coordinate
     * @param hover  when added to a base object, this element's y-coordinate is the
     *               other object's y-coordinate, minus this element's height, minus
     *               the hover amount
     */
    public AttachedElement(int width, int height, int offset, int hover) {
        super(0, 0, width, height);
    }

    /**
     * Sets base element for this attached element.
     * 
     * @param b the base element to be set
     */
    public void setBase(AbstractElement b) {
        base = b;
        setPosition(base.getXReal() + initialOffset, base.getYReal() - getHeight());
        setBounds(base.getXReal(), base.getXReal() + base.getWidth());
    }

    /**
     * Updates position of the attached element based on the movement of the base element.
     */
    public void update() {
        setFrameCount(getFrameCount() + 1);

        if (getYReal() >= max) {
            setPosition(getXReal(), max);
            setVelocity(getYReal() - getHeight(), -getDeltaY());
        }
        else if (getYReal() - getHeight() <= getHeight()) {
            setPosition(getXReal(), min + getHeight());
            setVelocity(getDeltaX(), -getDeltaY());
        }

        for (AbstractElement aElement : associatedElements) {
            aElement.update();
        }
    }
}