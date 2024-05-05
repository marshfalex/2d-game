package api;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Interface representing minimal features of something
 * that can be drawn on a graphics context.
 * @author smkautz
 */
public interface Drawable
{
  /**
   * Renders this object using the given graphics context.
   * @param g
   *   graphics context
   */
  void draw(Graphics g);
  
  /**
   * Returns the horizontal coordinate of the upper-left corner
   * of this object's bounding rectangle, rounded to the nearest
   * integer.
   * @return
   *   x-coordinate of bounding rectangle
   */
  int getXInt();
  
  /**
   * Returns the vertical coordinate of the upper-left corner
   * of this object's bounding rectangle, rounded to the nearest
   * integer.
   * @return
   *   y-coordinate of bounding rectangle
   */  
  int getYInt();
  
  /**
   * Returns the width of this object's bounding rectangle.
   * @return
   *   width of bounding rectangle
   */
  int getWidth();
  
  /**
   * Returns the height of this object's bounding rectangle.
   * @return
   *   height of bounding rectangle
   */
  int getHeight();
  
  /**
   * Returns the bounding rectangle for this object as an instance
   * of <code>java.awt.Rectangle</code>.
   * @return
   *   bounding rectangle 
   */
  Rectangle getRect();
  
}
