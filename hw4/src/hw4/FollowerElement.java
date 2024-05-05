package hw4;
import api.AbstractElement; 

/**
 * A follower element is one that is associated with another "base" element such
 * as a PlatformElement or LiftElement. Specifically, the follower element's
 * movement is determined by the movement of the base element, when the base
 * move up 10 pixels, the follower moves up 10 pixels. However, the follower may
 * not always be at a fixed location relative to the base. When the horizontal
 * velocity of the follower is set to a non-zero value, the follower will
 * oscillate between the left and right edges of the PlatformElement or
 * LiftElement it is associated with.
 * 
 * @author Marshall Alexander
 */
public class FollowerElement extends MovingElement {

	/**
	 * Constructs a new FollowerElement. Before being added to a "base" element such
	 * as a PlatformElement or LiftElement, the x and y coordinates are zero. When a
	 * base element is set, the initial x-coordinate becomes the base's
	 * x-coordinate, plus the given offset, and the y-coordinate becomes the base's
	 * y-coordinate, minus this element's height.
	 * 
	 * @param width         element's width
	 * @param height        element's height
	 * @param initialOffset when added to a base, this amount will be added to the
	 *                      bases's x-coordinate to calculate this element's initial
	 *                      x-coordinate
	 */
	
	private int initialOffset;
	private double min;
	private double max;
	private AbstractElement base;

	public FollowerElement(int width, int height, int initialOffset) {
		super(0,0,width, height);
		this.initialOffset = initialOffset;
	}
	
	public void setBase(AbstractElement b) {
		base = b;
		setPosition(base.getXReal()+initialOffset, base.getYReal() - getHeight());
		setBounds(base.getXReal(), base.getXReal()+base.getWidth());
	}
	
	@Override
	public void update() {
		setFrameCount(getFrameCount()+1);
		setBounds(base.getXReal(), base.getXReal()+base.getWidth());
		setPosition(getXReal()+((MovingElement) base).getDeltaX(),base.getYReal()-getHeight());

		if(getXReal() + getWidth() >= max) {
			setPosition(max- getWidth(), base.getYReal() - getHeight());
			setVelocity(getDeltaX()* -1, getDeltaY());
		}
		else if(getXReal() <= min) {
			setPosition(min+initialOffset, base.getYReal()-getHeight());
			setVelocity(getDeltaX()*-1, getDeltaY());
		}
	}

	public void setBounds(double min, double max){
		this.min = min;
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public double getMax() {
		return max;
	}
}
