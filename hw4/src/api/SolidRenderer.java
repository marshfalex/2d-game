package api;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Renderer that fills an element's bounding rectangle
 * with a solid color.
 * @author smkautz
 *
 */
public class SolidRenderer implements Renderer
{
  /**
   * The color.
   */
  private Color c;
  
  /**
   * Constructs a SolidRenderer that will use the given color.
   * @param givenColor
   *   the color
   */
  public SolidRenderer(Color givenColor)
  {
    c = givenColor;
  }

  
  @Override
  public void render(Graphics g, Drawable s)
  {
    Color savedColor = g.getColor();
    g.setColor(c);
    g.fillRect(s.getXInt(), s.getYInt(), s.getWidth(), s.getHeight());
    g.setColor(savedColor);   
  }
}
