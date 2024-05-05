package hw4;

/**
 * Moving element in which the vertical velocity is adjusted each frame by a
 * gravitational constant to simulate gravity. The element can be set to
 * "isGrounded", meaning gravity will no longer influence its velocity.
 * 
 * @author Marshall Alexander
 */

public class FlyingElement extends MovingElement{

	/**
	 * Constructs a new FlyingElement. By default it should be isGrounded, meaning
	 * gravity does not influence its velocity.
	 * 
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	private double gravity;
	private boolean isGrounded;
	
	public FlyingElement(double x, double y, int width, int height) {
		super(x,y,width,height);
		isGrounded = true;
	}
	
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	
	public void setGrounded(boolean isGrounded) {
		this.isGrounded = isGrounded;
	}
	
	public boolean isGrounded() {
		return isGrounded;
	}
	
	@Override
	public void update() {
		super.update();

		if(!isGrounded()) {
			setVelocity(getDeltaX(),getDeltaY()+gravity);
		}
	}
}
