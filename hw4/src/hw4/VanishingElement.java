package hw4;

/**
 * An element that does not move. Instead, it is intended to appear on the
 * screen for a fixed number of frames.
 * 
 * @author Marshall Alexander
 */

public class VanishingElement extends SimpleElement {

	/**
	 * Constructs a new VanishingElement.
	 * 
	 * @param x           x-coordinate of upper left corner
	 * @param y           y-coordinate of upper left corner
	 * @param width       element's width
	 * @param height      element's height
	 * @param initialLife the number of frames until this element marks itself for
	 *                    deletion
	 */
	private int frame;
	
	public VanishingElement(double x, double y, int width, int height, int initialLife) {
		super(x,y,width,height);
		this.frame = initialLife;
	}

	@Override
	public void update() {
		super.update();

		if(getFrameCount() >= frame) {
			markForDeletion();
		}
	}
}
