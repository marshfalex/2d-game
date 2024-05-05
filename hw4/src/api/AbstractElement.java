
package api;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Implementation of the Drawable interface associates a drawable
 * object with a Renderer to use for drawing.  In addition, this
 * class specifies some features useful for elements in a 
 * 2d video game.
 * <p>
 * Every element has an
 * "exact" position represented by an (x, y) pair of floating-point values.
 * This position is the upper-left corner of a bounding rectangle whose
 * width and height are additional attributes. Other attributes include
 * a frame counter and a flag that allows an application to "mark" an
 * object for subsequent deletion. A key operation is the <code>update</code>
 * method, which an application would normally call each frame. At a minimum
 * the <code>update</code> method should increment the frame count, but 
 * more generally, subclasses would override the method to implement
 * features such as movement.
 */
public abstract class AbstractElement implements Drawable
{
  /**
   * Renderer instance to be used for drawing this object.
   */
  private Renderer renderer;
  
  /**
   * Constructs a drawable with a default renderer that will 
   * simply paint the bounding rectangle in green
   */
  protected AbstractElement()
  {
    renderer = new SolidRenderer(Color.GREEN);
  }
  
  /**
   * Constructs a drawable with a default renderer that will 
   * simply paint the bounding rectangle in the given color.
   * @param c
   *   Color to use for rendering
   */
  protected AbstractElement(Color c)
  {
    renderer = new SolidRenderer(c);
  }
  /**
   * Constructs a drawable that will use the given renderer.
   * @param r
   *   given renderer
   */
  protected AbstractElement(Renderer r)
  {
    renderer = r;
  }
  
  /**
   * Sets this object's Renderer.
   * @param r
   *   given Renderer
   */
  public void setRenderer(Renderer r)
  {
    this.renderer = r;
  }

  /**
   * Sets this object's renderer to a default renderer that will 
   * simply paint the bounding rectangle in the given color.
   * @param c
   *   Color to use for rendering
   */
  public void setColor(Color c)
  {
    this.renderer = new SolidRenderer(c);
  }
  
  /**
   * Uses this object's Renderer to draw the object.
   * @param g
   *   graphics context for rendering
   */
  @Override
  public void draw(Graphics g)
  {
    renderer.render(g, this);
  }

  /**
   * Sets the position of this element.
   * @param newX
   *   the new x-coordinate
   * @param newY
   *   the new y-coordinate
   */
  public abstract void setPosition(double newX, double newY);

  /**
   * Returns the x-coordinate's exact value as a double.
   * @return
   *   the x-coordinate
   */
  public abstract double getXReal();

  /**
   * Returns the y-coordinate's exact value as a double.
   * @return
   *   the y-coordinate
   */
  public abstract double getYReal();

  /**
   * Updates this object's attributes for the next frame.
   */
  public abstract void update();
  
  /**
   * Returns the number of times that update() has been invoked for this
   * object.
   * @return
   *   number of frames
   */
  public abstract int getFrameCount();
 
  /**
   * Returns true if this element has been marked for deletion.
   * @return
   *   true if this element has been marked for deletion
   */
  public abstract boolean isMarked();
  
  /**
   * Marks this element for deletion.
   */
  public abstract void markForDeletion();

  /**
   * Determines whether this element's bounding rectangle overlaps the 
   * given element's bounding rectangle.
   * @param other
   *   given element
   * @return
   *   true if this element overlaps the given element
   */
  public abstract boolean collides(AbstractElement other);

}
