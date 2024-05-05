package hw4;
import java.util.ArrayList;
import api.AbstractElement; 
/**
 * A PlatformElement is an element with two distinctive behaviors. First, it can
 * be set up to move horizontally within a fixed set of boundaries. On reaching
 * a boundary, the x-component of its velocity is reversed. Second, it maintains
 * a list of <em>associated</em> elements whose basic motion all occurs relative
 * to the PlatformElement.
 * 
 * @author Marshall Alexander
 */
public class PlatformElement extends MovingElement{

	/**
	 * Constructs a new PlatformElement. Initially the left and right boundaries are
	 * <code>Double.NEGATIVE_INFINITY</code> and
	 * <code>Double.POSITIVE_INFINITY</code>, respectively.
	 * 
	 * @param x      x-coordinate of initial position of upper left corner
	 * @param y      y-coordinate of initial position of upper left corner
	 * @param width  object's width
	 * @param height object's height
	 */
	private double min;
	private double max;
	private ArrayList<AbstractElement> associatedElements;;
	
	public PlatformElement(double x, double y, int width, int height) {
		super(x,y,width,height);
		associatedElements = new ArrayList<>();
		setBounds(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}
	
	public double getMax() {
		return max;
	}
	
	public double getMin() {
		return min;
	}
	
	public void setBounds(double min, double max) {
		this.min=min;
		this.max=max;
	}

	public void addAssociated(FollowerElement follower) {
		associatedElements.add(follower);
		follower.setBase(this);
	}

	public void addAssociated(AttachedElement attached) {
		associatedElements.add(attached);
		attached.setBase(this);
	}
	
	public ArrayList<AbstractElement> getAssociated() {
		return associatedElements;
	}
	
	public void deleteMarkedAssociated() {
		for (AbstractElement e : getAssociated()) {
			if(e.isMarked()) {
				getAssociated().remove(e);
			}
		}
	}
	
	@Override 
	public void update() {
		super.update();

		if (getXReal() <= min) {
			super.setPosition(min, getYReal());
			setVelocity(-1 * getDeltaX(), getDeltaY());
		}
		else if (getXReal() + getWidth() >= max) {
			super.setPosition(max - getWidth(), getYReal());
			setVelocity(-1 * getDeltaX(), getDeltaY());
		}

		for (int i = 0; i <= associatedElements.size(); i++) {
			associatedElements.get(i).update();
		}
	}
}
