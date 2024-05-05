package hw4;

import java.util.ArrayList;

import api.AbstractElement;

/**
 * An element with two distinctive behaviors. First, it can be set up to move
 * vertically within a fixed set of boundaries. On reaching a boundary, the
 * y-component of its velocity is reversed. Second, it maintains a list of
 * <em>associated</em> elements whose basic motion all occurs relative to the
 * LiftElement.
 * 
 * @author Marshall Alexander
 */

public class LiftElement extends PlatformElement {

	/**
	 * Constructs a new Elevator. Initially the upper and lower boundaries are
	 * <code>Double.NEGATIVE_INFINITY</code> and
	 * <code>Double.POSITIVE_INFINITY</code>, respectively.
	 * 
	 * @param x      x-coordinate of initial position of upper left corner
	 * @param y      y-coordinate of initial position of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	
	private double max;
	private double min;
	private ArrayList<AbstractElement> associatedElement;
	
	public LiftElement(double x, double y, int width, int height) {
		super(x,y,width,height);
	}
	
	@Override
	public void update() {
		setFrameCount(getFrameCount()+1);
		
		if(getYReal() >= max) {
			setPosition(getXReal(), max);
			setVelocity(getDeltaX(), -getDeltaY());
		}
		else if(getYReal() - getHeight() <= getHeight()) {
			setPosition(getXReal(), min + getHeight());
			setVelocity(getDeltaX(), -getDeltaX());
		}

		for(AbstractElement aElement : associatedElement) {
			aElement.update();
		}
	}
}