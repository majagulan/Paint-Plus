/* Drawing consists of rendering each of the Shape objects stored
   in the shapes ArrayList. A Shape may be a LineShape, OvalShape,
   or RectangleShape.

   Freehand drawing is implemented as a series of short LineShapes
   which are generated as the user drags the mouse over the screen.
   Freehand lines are extra thick, and have rounded caps and joins.

*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;


public class DrawPanel extends JPanel
{
  // shape drawing constants
  private static final int FREEHAND = 0;
  private static final int OVAL = 1;
  private static final int RECTANGLE = 2;
  private static final int TRIANGLE = 3;
  private static final int LINE = 4;
  private static final int TEXT = 5;
  private static final int ERASER = 6;

  //thickness of freehand line
  private static final float THICKNESS1 = 4.0f;
  private static final float THICKNESS2 = 5.0f;
  private static final float THICKNESS3 = 6.0f;
  private static final float THICKNESS4 = 7.0f;
  private static final float THICKNESS5 = 8.0f;


  // for storing the paintable shapes
  private ArrayList<Shape> shapes;    // stores Shape objects; using J2SE 5 generics

  private Shape currShape = null;
  private int currShapeType;    // freehand, oval, rectangle, or line
  private boolean isFilled;
  private boolean isInterrupted;
  private boolean isBold;
  private boolean isItalic;
  private float currThick;
  private Color drawColour;
  private String currString = null;
  private int currFontSize;
  private String currFont;

  private int oldShapeType;
  private Color oldColour;


  private int prevShape;

  private int xCoord, yCoord;   // mouse location

  public DrawPanel()
  {
    shapes = new ArrayList<Shape>();   // using J2SE 5 generics

    // defaults for drawing shape and colour
    currShapeType = FREEHAND;
    currThick = THICKNESS1;
    isFilled = true;
    isInterrupted = false;
    isBold = false;
    isItalic = false;
    currFontSize = 20;
    currFont = "Serif";
    drawColour = Color.BLACK;

    setBackground(Color.white);

    addMouseListener( new ShapeMouseListener() );
    addMouseMotionListener( new MovingMouseListener() );
  } // end of DrawPanel() constructor


  public void paintComponent(Graphics g)
  // repaint the panel by redrawing all the stored shapes
  {
    super.paintComponent(g);   // repaint standard stuff first

    // put black 'border' around the panel
    g.setColor(Color.black);
    g.drawRect(1, 1, getWidth()-2, getHeight()-2);


    // draw all the stored shapes
    Shape s;
    for (int i = 0; i < shapes.size(); i++)
    {
    	s = (Shape) shapes.get(i);
		s.draw(g);

		if (currShapeType != TEXT)
			prevShape = currShapeType;
    }


    // draw the current shape
    if (currShape != null)
      currShape.draw(g);

  } // end of paintComponent()


  // --------- methods called from MyMenuBar -----------------

  public void setShape(int shapeType)
  { currShapeType = shapeType; }

  public void setFilled(boolean b)
  { isFilled = b; }

  public void setInterrupted(boolean b)
  { isInterrupted = b; }

  public void setThickness(float thick)
  { currThick = thick; }

  public void setColour(Color c)
  { drawColour = c; }

  public void setCurrString(String currString)
  { this.currString = currString; }

  public void setBold(boolean b)
  { isBold = b; }

  public void setItalic(boolean b)
  { isItalic = b; }

  public void setFontSize(int s)
  { currFontSize = s; }

  public void setFont(String s)
  { currFont = s; }

  public void clear()
  // wipe the drawing surface clean
  { shapes.clear();
    currShape = null;
    currString = null;
    repaint();
  }  // end of clear()


  // ---------------------------member classes -----------------------

  private class ShapeMouseListener extends MouseAdapter
  // listen for mouse press & release events inside the drawing area
  {
    public void mousePressed(MouseEvent e)
    // start a new shape
    {
      xCoord = e.getX();   // remember mouse location
      yCoord = e.getY();
      // System.out.println("Mouse pressed at (" + xCoord + "," + yCoord + ")" );

      // the new shape depends on the current shape type

      if (currShapeType == FREEHAND)  // use a line
      {
	    	if (currThick == THICKNESS1)
		   	 currShape = new LineShape(xCoord, yCoord, xCoord, yCoord, drawColour, THICKNESS1, isInterrupted);
	    	else if (currThick == THICKNESS2)
	   	   	 currShape = new LineShape(xCoord, yCoord, xCoord, yCoord, drawColour, THICKNESS2, isInterrupted);
	    	else if (currThick == THICKNESS3)
	   	   	 currShape = new LineShape(xCoord, yCoord, xCoord, yCoord, drawColour, THICKNESS3, isInterrupted);
	    	else if (currThick == THICKNESS4)
	   	   	 currShape = new LineShape(xCoord, yCoord, xCoord, yCoord, drawColour, THICKNESS4, isInterrupted);
	    	else if (currThick == THICKNESS5)
	   	   	 currShape = new LineShape(xCoord, yCoord, xCoord, yCoord, drawColour, THICKNESS5, isInterrupted);
      }

      else if (currShapeType == OVAL)
	    currShape = new OvalShape(xCoord, yCoord, xCoord, yCoord, isFilled, drawColour, isInterrupted, isBold,
                isItalic, currFont, currFontSize, currString);

      else if (currShapeType == RECTANGLE)
	    currShape = new RectangleShape(xCoord, yCoord, xCoord, yCoord, isFilled, drawColour, isInterrupted, isBold,
                isItalic, currFont, currFontSize, currString);

      else if (currShapeType == TRIANGLE)
  	    currShape = new TriangleShape(xCoord, yCoord, xCoord, yCoord, isFilled, drawColour, isInterrupted, isBold,
                isItalic, currFont, currFontSize, currString);

      else if (currShapeType == LINE)
      {
	    	if (currThick == THICKNESS1)
	    		currShape = new LineShape(xCoord, yCoord, xCoord, yCoord, drawColour, THICKNESS1, isInterrupted);
	      	else if (currThick == THICKNESS2)
	      		currShape = new LineShape(xCoord, yCoord, xCoord, yCoord, drawColour, THICKNESS2, isInterrupted);
	    	else if (currThick == THICKNESS3)
	    		currShape = new LineShape(xCoord, yCoord, xCoord, yCoord, drawColour, THICKNESS3, isInterrupted);
	    	else if (currThick == THICKNESS4)
	    		currShape = new LineShape(xCoord, yCoord, xCoord, yCoord, drawColour, THICKNESS4, isInterrupted);
	    	else if (currThick == THICKNESS5)
	    		currShape = new LineShape(xCoord, yCoord, xCoord, yCoord, drawColour, THICKNESS5, isInterrupted);
       }

      else if (currShapeType == TEXT)
      {
    	  currShape = new MyText(xCoord, yCoord, xCoord, yCoord, isFilled, drawColour, isInterrupted, isBold, isItalic, currFont, currFontSize, currString);
    	  repaint();
      }

      else if (currShapeType == ERASER)
      {
    	  if (currThick == THICKNESS1)
    		  currShape = new Eraser(xCoord, yCoord, xCoord, yCoord, Color.WHITE, THICKNESS1, false);
 	      else if (currThick == THICKNESS2)
 	    	  currShape = new Eraser(xCoord, yCoord, xCoord, yCoord, Color.WHITE, THICKNESS2, false);
 	      else if (currThick == THICKNESS3)
 	   	  	currShape = new Eraser(xCoord, yCoord, xCoord, yCoord, Color.WHITE, THICKNESS3, false);
 	      else if (currThick == THICKNESS4)
 	   	  	currShape = new Eraser(xCoord, yCoord, xCoord, yCoord, Color.WHITE, THICKNESS4, false);
 	      else if (currThick == THICKNESS5)
 	   	  	currShape = new Eraser(xCoord, yCoord, xCoord, yCoord, Color.WHITE, THICKNESS5, false);
      }

      else
	    System.out.println("Unknown shape type in draw panel");

    } // end mousePressed()


    public void mouseReleased(MouseEvent e)
    // store the current shape since it is finished
    {
      // System.out.println("Mouse released at (" + e.getX() + "," + e.getY() + ")" );

      shapes.add(currShape);    // store the finished shape
      currShape = null;
      repaint();

      if (currShapeType == TEXT)
    	  currShapeType = prevShape;

    } // end of mouseReleased()

  } // end of ShapeMouseListener class


  // ----------------------------------------------------------

  private class MovingMouseListener extends MouseMotionAdapter
  // Listener for mouse dragging events inside the drawing area
  {
    public void mouseDragged(MouseEvent e)
    // grow/adjust the current shape by mouse dragging
    {
      int xc = e.getX();
      int yc = e.getY();
	  // System.out.println("Dragged: (" + xc + ", " + yc + ")");

      if (currShape == null)
      {
	    System.out.println("Error: current shape is null");
	    System.exit(1);
      }

      //FREEHAND
      else if (currShapeType == FREEHAND) // end current line, start another
      {

	    currShape.adjustShape(xCoord, yCoord, xc, yc);
        shapes.add(currShape);
        xCoord = xc; yCoord = yc;

	        if (currThick == THICKNESS1) {
	   	   	   currShape = new LineShape(xCoord, yCoord, xCoord, yCoord, drawColour, THICKNESS1, isInterrupted);
	   	   	   repaint();
	        }
	       	else if (currThick == THICKNESS2) {
	      	   currShape = new LineShape(xCoord, yCoord, xCoord, yCoord, drawColour, THICKNESS2, isInterrupted);
	      	   repaint();
	        }
	       	else if (currThick == THICKNESS3) {
	      	   currShape = new LineShape(xCoord, yCoord, xCoord, yCoord, drawColour, THICKNESS3, isInterrupted);
	      	   repaint();
	        }
	       	else if (currThick == THICKNESS4) {
	      	   currShape = new LineShape(xCoord, yCoord, xCoord, yCoord, drawColour, THICKNESS4, isInterrupted);
	      	   repaint();
	        }
	       	else if (currThick == THICKNESS5) {
	      	   currShape = new LineShape(xCoord, yCoord, xCoord, yCoord, drawColour, THICKNESS5, isInterrupted);
	           repaint();
	       	}

      }  //END OF FREEHAND


	  else if ((currShapeType == OVAL) || (currShapeType == RECTANGLE) || (currShapeType == LINE) || (currShapeType == TRIANGLE))
	  {
	      	currShape.adjustShape(xCoord, yCoord, xc, yc);
	      	repaint();
	  } //END OF OTHER SHAPES

	  else if ((currShapeType == TEXT))
	  {
	  }

	  else if ((currShapeType == ERASER))
	  {
		  currShape.adjustShape(xCoord, yCoord, xc, yc);
	      shapes.add(currShape);
	      xCoord = xc; yCoord = yc;

	      if (currThick == THICKNESS1) {
	   	   	 currShape = new Eraser(xCoord, yCoord, xCoord, yCoord, Color.WHITE, THICKNESS1, false);
	   	     repaint();
	      }
	      else if (currThick == THICKNESS2) {
	      	 currShape = new Eraser(xCoord, yCoord, xCoord, yCoord, Color.WHITE, THICKNESS2, false);
	         repaint();
	      }
	      else if (currThick == THICKNESS3) {
	      	 currShape = new Eraser(xCoord, yCoord, xCoord, yCoord, Color.WHITE, THICKNESS3, false);
	         repaint();
	      }
	      else if (currThick == THICKNESS4) {
	      	 currShape = new Eraser(xCoord, yCoord, xCoord, yCoord, Color.WHITE, THICKNESS4, false);
	      	 repaint();
	      }
	       	else if (currThick == THICKNESS5) {
	      	 currShape = new Eraser(xCoord, yCoord, xCoord, yCoord, Color.WHITE, THICKNESS5, false);
	         repaint();
	      }


	  }	// END OF ERASER

	  else
	  	System.out.println("Unknown shape type in draw panel");


    } // end of mouseDragged()

   } // end of MovingMouseListener class


public void setOldShapeType()
{ oldShapeType = currShapeType; }

public void setOldColour()
{ oldColour = drawColour; }

public void setNextShapeType()
{ currShapeType = oldShapeType; }

public void setNextColour()
{ drawColour = oldColour; }


} // end of DrawPanel class
