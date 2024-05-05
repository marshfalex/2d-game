package api;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Renderer that draws a solid circle in an element's bounding 
 * rectangle.
 * @author smkautz
 */
public class CircleRenderer implements Renderer
{
  /**
   * The color.
   */
  private Color c;
  
  /**
   * Desired margin between bounding rectangle and circle.
   */
  private int margin;

  public CircleRenderer(Color givenColor)
  {
    c = givenColor;
  }
  
  /**
   * Sets the margin, in pixels.
   * @param margin
   *   given margin
   */
  public void setMargin(int margin)
  {
    this.margin = margin;
  }
  
  @Override
  public void render(Graphics g, Drawable s)
  {
    int x = s.getXInt();
    int y = s.getYInt();
    int w = s.getWidth();
    int h = s.getHeight();
    
    // margin should leave at least four pixels in center
    int min = Math.min((w - 4) / 2, (h - 4) / 2);
    min = Math.min(min, margin);
    int m = Math.max(0, min);
        
    Color savedColor = g.getColor();
    g.setColor(c);
    g.fillOval(x + m, y + m, w - 2 * m, h - 2 * m);
    g.setColor(savedColor); 

  }
}
