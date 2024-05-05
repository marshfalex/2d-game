package hw4;
import api.AbstractElement;
import java.awt.Rectangle;

/**
 * I transitioned it from AbstractElement to SimpleElement, then to VanishingElement 
 * and MovingElement, then to Platform and AttachedElement. Finally, it went from 
 * MovingElement to LiftElement and from AttachedElement to FollowerElement.
 */

/**
 * Minimal concrete extension of AbstractElement. The <code>update</code> method
 * in this implementation just increments the frame count.
 * 
 * @author Marshall Alexander
 */
public class SimpleElement extends AbstractElement{

	/**
	 * Constructs a new SimpleElement.
	 * 
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	private double x;
	private double y;
	private int width;
	private int height;
	private int frameCount;
	private boolean markedForDeletion;
	
	public SimpleElement(double x, double y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.frameCount = 0;
		this.markedForDeletion = false;
	}

	@Override
	public void setPosition(double newX, double newY) {
		this.x = newX;
		this.y = newY;
	}
	
	@Override
	public double getXReal() {
		return x;
	}
	
	@Override
	public int getXInt() {
		return (int) Math.round(x);
	}
	
	@Override
	public double getYReal(){
		return y;
	}
	
	@Override
	public int getYInt() {
		return (int) Math.round(y);
	}
	
	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public int getHeight() {
		return height;
	}
	
	@Override
	public Rectangle getRect() {
		return new Rectangle(getXInt(), getYInt(), getWidth(), getHeight());
	}
	
	@Override
	public boolean collides(AbstractElement other){
		Rectangle r1 = getRect();
		return r1.intersects(other.getRect());
	}
	
	@Override
	public void update() {
		setFrameCount(getFrameCount()+1);
	}

	protected void setFrameCount(int frameCount) {
		this.frameCount = frameCount;
	}

	public int getFrameCount() {
		return frameCount;
	}

	public void markForDeletion() {
		markedForDeletion = true;
	}

	public boolean isMarked() {
		return markedForDeletion;
	}
}
