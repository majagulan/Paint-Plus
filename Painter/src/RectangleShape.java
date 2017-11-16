/* Represents a rectangular shape.
   Implements the Shape class by defining draw().
*/

import java.awt.*;


public class RectangleShape extends Shape
{
  public RectangleShape(int x1, int y1, int x2, int y2,
	                        boolean isFilled, Color colour, boolean isInterrupted, boolean isBold,
	 	                   boolean isItalic, String cFont, int cFontSize, String cString)
  {  super(x1, y1, x2, y2, isFilled, colour, isInterrupted, isBold, isItalic,
          cFont, cFontSize, cString);  }


  public void draw(Graphics g)
  // draws the rectangle
  {
    g.setColor(colour);
    if (isFilled)
      g.fillRect(topX, topY, width, height);
    else
      g.drawRect(topX, topY, width, height);
  } // end of draw()

} // end of RectangleShape class
