package api;

import java.awt.Graphics;

/**
 * Interface represents a strategy for drawing a Drawable
 * object into a given graphics context.
 * @author smkautz
 */
public interface Renderer
{
  /**
   * Draws the given Drawable in the given graphics context.
   * @param g
   *   graphics context
   * @param drawable
   *   given Drawable object
   */
  void render(Graphics g, Drawable drawable);
}
