package hw4;
import api.AbstractElement;

/**
 * An element in which the <code>update</code> method updates the position each
 * frame according to a <em>velocity</em> vector (deltaX, deltaY). The units are
 * assumed to be "pixels per frame".
 *
 * @author Marshall Alexander
 */
public class MovingElement extends SimpleElement {

    /**
     * velocity in the x-direction
     */
    private double velX;

    /**
     * velocity in the y-direction
     */
    private double velY;

    /**
     * Constructs a MovingElement with a default velocity of zero in both
     * directions.
     * 
     * @param x      x-coordinate of upper left corner
     * @param y      y-coordinate of upper left corner
     * @param width  object's width
     * @param height object's height
     */
    public MovingElement(double x, double y, int width, int height) {
        super(x, y, width, height);
        this.velX = 0;
        this.velY = 0;
    }

    /**
     * Sets velocity of the element.
     * 
     * @param deltaX the velocity in the x-direction
     * @param deltaY the velocity in the y-direction
     */
    public void setVelocity(double deltaX, double deltaY) {
        this.velX = deltaX;
        this.velY = deltaY;
    }

    /**
     * Retrieves current velocity in the x-direction.
     * 
     * @return the velocity in the x-direction
     */
    public double getDeltaX() {
        return this.velX;
    }

    /**
     * Retrieves current velocity in the y-direction.
     * 
     * @return the velocity in the y-direction
     */
    public double getDeltaY() {
        return this.velY;
    }

    /**
     * Adjusts elements position according to its current velocity.
     * The updated position is found by adding the velocity vectors
     * components to the current position.
     */
    @Override
    public void update() {
        setPosition(getXReal() + velX, getYReal() + velY);
        super.update();
    }
}