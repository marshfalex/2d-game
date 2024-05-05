package api;

import java.awt.Color;
import java.awt.Graphics;

import hw4.SimpleElement;

/**
 * Renderer that changes the way something is drawn over time, 
 * gradually making it fade in to the background color.
 */
public class ExplosionRenderer implements Renderer
{
  /**
   * How long (in terms of calls to update()) it will take
   * before this object is not visible.
   */
  private int lifetime;
  
  /**
   * Initial color.
   */
  private Color c;
  
  /**
   * Background color.
   */
  private Color background;

  /**
   * Constructs a renderer that will fade the given color to the background color
   * over the given lifetime.
   * @param givenLifetime
   * @param givenColor
   * @param background
   */
  public ExplosionRenderer(int givenLifetime, Color givenColor, Color background)
  {
    this.lifetime = givenLifetime;
    c = givenColor;
    this.background = background;
  }


  @Override
  public void render(Graphics g2, Drawable s)
  {
    int count = ((AbstractElement) s).getFrameCount();
    count = Math.min(lifetime,  count);
    double r = c.getRed();
    double g = c.getGreen();
    double b = c.getBlue();

    // figure out how much to adjust the color each frame so it will
    // fade to the background
    double rfrac = (background.getRed() - r) / lifetime;
    double gfrac = (background.getGreen() - g) / lifetime;
    double bfrac = (background.getBlue() - b) / lifetime;

    r = r + count * rfrac;
    g = g + count * gfrac;
    b = b + count * bfrac;

    Color savedColor = g2.getColor();
    double centerX = s.getXInt() + s.getWidth() / 2.0;
    double centerY = s.getYInt() + s.getHeight() / 2.0;
    double w = s.getWidth() + ((double) count) / lifetime * s.getWidth();
    double h = s.getHeight() + ((double) count) / lifetime * s.getHeight();
    Color toDraw = new Color((int) r, (int) g, (int) b);
    g2.setColor(toDraw);
    g2.fillOval((int) (centerX - w / 2), (int) (centerY - h / 2), (int) w, (int) h);
    g2.setColor(savedColor);    

  }

}
