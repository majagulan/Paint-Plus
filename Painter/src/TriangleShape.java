
import java.awt.Color;
import java.awt.Graphics;

public class TriangleShape extends Shape {
	
	public TriangleShape(int x1, int y1, int x2, int y2, boolean isFilled,
			Color colour, boolean isInterrupted, boolean isBold,
             boolean isItalic, String cFont, int cFontSize, String cString) {
		super(x2, y2, x1, y1, isFilled, colour, isInterrupted, isBold, isItalic,
		          cFont, cFontSize, cString); }	
	// end of TrinagleShape()	
		

	public void draw(Graphics g) 
		// draws the triangle
	{
		g.setColor(colour);
		
		int xPoints[] = {topX+width/2, topX+width, topX};
		int yPoints[] = {topY, topY+height, topY+height};
		
		
		if (isFilled)
			g.fillPolygon(xPoints, yPoints, 3);
		else
			g.drawPolygon(xPoints, yPoints, 3);
		
	}	// end of draw()

}	// end of TriangleShape class
