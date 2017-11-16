/* Abstract shape class. Concrete classes are created by
   defining the draw() method.
*/

import java.awt.*;

public abstract class Shape
{
  protected int topX, topY;     // top left coordinate of the shape
  protected int width, height;
  protected boolean isFilled;   // is the shape filled with colour?
  protected boolean isInterrupted;
  protected boolean isBold;
  protected boolean isItalic;
  protected String cFont;
  protected int cFontSize;
  protected Color colour;
  protected String cString;

  protected Point startPt, endPt;   // the two points used for the shape

  public Shape(int x1, int y1, int x2, int y2,
	            boolean isFilled, Color colour, boolean isInterrupted, boolean isBold, boolean isItalic,
	            String cFont, int cFontSize, String cString)
  {
    startPt = new Point(x1,y1);
    endPt = new Point(x2,y2);

    adjustShape(x1, y1, x2, y2);   // diagonally opposite corners of the shape
    this.isFilled = isFilled;
    this.isInterrupted = isInterrupted;
    this.colour = colour;
    this.isBold = isBold;
    this.isItalic = isItalic;
    this.cFont = cFont;
    this.cFontSize = cFontSize;
    this.cString = cString;

  } // end of Shape()


  public void adjustShape(int x1, int y1, int x2, int y2)
  /* Adjust the location and dimensions of the shape.
     (x1,y1) and (x2,y2) are diagonally opposite corners of the
     bounding rectangle for the shape.
  */
  {
    // Store the top left corner, and calculate width and height
    if (x1 < x2) {
      topX = x1;
      width = x2 - x1;
    }
    else if (x1 > x2) {
      topX = x2;
      width = x1 - x2;
    }
    else if (x1 == x2) {
        topX = x1;
        width = 0;
     }
    //
    if (y1 < y2) {
      topY = y1;
      height = y2 - y1;
    }
    else if (y1 > y2) {
      topY = y2;
      height = y1 - y2;
    }
    else if (y1 == y2) {
        topY = y1;
        width = 0;
     }

    // store the input points
    startPt.x = x1; startPt.y = y1;
    endPt.x = x2; endPt.y = y2;
  } // end of adjustShape()



  public abstract void draw(Graphics g);
  // draws the shape on the screen

} // end of Shape class
