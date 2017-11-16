/* Represents a line.
   Implements the Shape class by defining draw().
*/

import java.awt.*;

public class LineShape extends Shape
{

  private BasicStroke lineStroke = null;
  public boolean isInterrupted = false;


  public LineShape(int x1, int y1, int x2, int y2, Color col, float thickness, boolean isInterrupted)
  {
    super(x1, y1, x2, y2, true, col, false, false, false, "", 0, "");

    //for freehand
    if (thickness == 4.0f) {

    	if (isInterrupted == false)
    		lineStroke = new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        else if (isInterrupted == true) {
    	    float[] dashPattern = { 4.0f, 4.0f, 4.0f, 4.0f };
    	    lineStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
    	    		10.0f, dashPattern, 10.0f);
       }
    }

    else if (thickness == 5.0f) {

    	if (isInterrupted == false)
    		lineStroke = new BasicStroke(5.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        else if (isInterrupted == true) {
    	    float[] dashPattern = { 4.0f, 4.0f, 4.0f, 4.0f };
    	    lineStroke = new BasicStroke(5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
    	    		10.0f, dashPattern, 10.0f);
       }
    }

    else if (thickness == 6.0f) {

    	if (isInterrupted == false)
    		lineStroke = new BasicStroke(10.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        else if (isInterrupted == true) {
    	    float[] dashPattern = { 4.0f, 4.0f, 4.0f, 4.0f };
    	    lineStroke = new BasicStroke(10.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
    	    		10.0f, dashPattern, 10.0f);
       }
    }

    else if (thickness == 7.0f) {

    	if (isInterrupted == false)
    		lineStroke = new BasicStroke(15.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        else if (isInterrupted == true) {
    	    float[] dashPattern = { 4.0f, 4.0f, 4.0f, 4.0f };
    	    lineStroke = new BasicStroke(15.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
    	    		10.0f, dashPattern, 10.0f);
       }
    }

    else if (thickness == 8.0f) {

    	if (isInterrupted == false)
    		lineStroke = new BasicStroke(20.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        else if (isInterrupted == true) {
    	    float[] dashPattern = { 4.0f, 4.0f, 4.0f, 4.0f };
    	    lineStroke = new BasicStroke(20.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
    	    		10.0f, dashPattern, 10.0f);
       }
    }


    //for line
    else if (thickness == 1.0f) {

    	if (isInterrupted == false)
    		lineStroke = new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        else if (isInterrupted == true) {
    	    float[] dashPattern = { 4.0f, 2.0f, 8.0f, 2.0f };
    	    lineStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
    	    		10.0f, dashPattern, 10.0f);
       }
    }


  } // end of LineShape()


  public void draw(Graphics g)
  // draw a line on screen
  {
    Graphics2D g2 = (Graphics2D) g;

    Stroke oldStroke = null;

    oldStroke = g2.getStroke();
    g2.setStroke(lineStroke);

    g2.setColor(colour);
    g2.drawLine(startPt.x, startPt.y, endPt.x, endPt.y);

    // restore original line thickness
    g2.setStroke(oldStroke);

  } // end of draw()

} // end of LineShape class
