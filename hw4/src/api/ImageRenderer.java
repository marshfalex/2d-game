package api;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

/**
 * Renderer implementation that will draw a given image within
 * an element's bounding rectangle.  Draws a default solid color if the
 * Image object is null.
 */
public class ImageRenderer implements Renderer
{
  /**
   * The image.
   */
  private Image image;
  
  /**
   * Default color to render if the image is null.
   */
  private Color defaultColor;
  
  /**
   * If true, the image is flipped horizontally.
   */
  private boolean hflip = false;
  
  /**
   * If true, the image is flipped vertically.
   */
  private boolean vflip = false;
  
  /**
   * If nonzero, the image is rotated counterclockwise this many degrees.
   */
  private int rotation = 0;
  
  /**
   * Constructs a renderer that will use the given image and 
   * default color.
   * @param im
   *   an Image object
   * @param defaultColor
   *   default color to use if the image is null
   */
  public ImageRenderer(Image im, Color defaultColor)
  {
    image = im;
    this.defaultColor = defaultColor;
  }
  
  /**
   * Sets the renderer to flip the image horizontally or not.
   * @param flip
   *   true if the image should be flipped horizontally, false otherwise
   */
  public void flipHorizontal(boolean flip)
  {
    hflip = flip;
  }
  
  /**
   * Sets the renderer to flip the image vertically or not.
   * @param flip
   *   true if the image should be flipped vertically, false otherwise
   */
  public void flipVertical(boolean flip)
  {
    vflip = flip;
  }
  
  /**
   * Sets the rotation in degrees counterclockwise.
   * @param r
   *   rotation in degreees
   */
  public void setRotation(int r)
  {
    rotation = r;
  }
  
  @Override
  public void render(Graphics g, Drawable s)
  {
    if (image != null)
    {
      int x = s.getXInt();
      int y = s.getYInt();
      int w = s.getWidth();
      int h = s.getHeight();
      if (hflip)
      {
        x = x + w;  
        w = -w;
      }
      if (vflip)
      {
        y = y + h;
        h = -h;
      }

      if (rotation == 0)
      {
        g.drawImage(image, x, y, w, h, null);
      }
      else
      {
        Graphics2D g2 = (Graphics2D) g;
        AffineTransform saveAT = g2.getTransform();
        double r = rotation * Math.PI / 180.0;  // radians
        double tx = x + w / 2.0;
        double ty = y + h / 2.0;
        g2.translate(tx, ty);
        g2.rotate(-r);
        g2.translate(-tx, -ty);
        g.drawImage(image, x, y, w, h, null);
        g2.setTransform(saveAT);
      }
    }
    else
    {     
      g.setColor(defaultColor);
      g.fillRect(s.getXInt(), s.getYInt(), s.getWidth(), s.getHeight());
    }
  }

  
}
