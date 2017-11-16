/* Represents an oval.
   Implements the Shape class by defining draw().
*/

import java.awt.*;


public class OvalShape extends Shape
{
  public OvalShape(int x1, int y1, int x2, int y2,
	                   boolean isFilled, Color colour, boolean isInterrupted, boolean isBold,
	                   boolean isItalic, String cFont, int cFontSize, String cString)
  {  super(x1, y1, x2, y2, isFilled, colour, isInterrupted, isBold, isItalic,
          cFont, cFontSize, cString);  }


  public void draw(Graphics g)
  // draw the oval on screen
  {
    g.setColor(colour);
    if (isFilled)
      g.fillOval(topX, topY, width, height);
    else
      g.drawOval(topX, topY, width, height);
  } // end of draw()

} // end of OvalShape class
