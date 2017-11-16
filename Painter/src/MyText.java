import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class MyText extends Shape {
	
	public MyText(int x1, int y1, int x2, int y2, boolean isFilled, Color colour, boolean isInterrupted, 
			boolean isBold, boolean isItalic, String cFont, int cFontSize, String cString) 
	{  super(x1, y1, x2, y2, isFilled, colour, isInterrupted, isBold, isItalic,
	          cFont, cFontSize, cString);
	}	
	
	public void draw(Graphics g) {
		
		g.setColor(colour);
		
		if (isBold == true && isItalic == false) 
	   	{
	   		g.setFont(new Font(cFont, Font.BOLD, cFontSize));
	   		g.drawString(cString, topX, topY);
	   	}
       else if (isItalic == true && isBold == false) 
       {
	      	g.setFont(new Font(cFont, Font.ITALIC, cFontSize));
	       	g.drawString(cString, topX, topY);
       }
       else if (isBold == true && isItalic == true) 
	   {
	       	g.setFont(new Font(cFont, Font.ITALIC | Font.BOLD, cFontSize));
	       	g.drawString(cString, topX, topY);
	   }
       else if (isBold == false && isItalic == false) 
       {
	       	g.setFont(new Font(cFont, Font.PLAIN, cFontSize));
	       	g.drawString(cString, topX, topY);
       }
		
	}

}
