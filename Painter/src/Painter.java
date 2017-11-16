/* A basic paint program which allows the user to draw freehand,
   and to add lines, rectangles, and ovals of different colours
   and sizes.
*/

import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;

public class Painter extends JFrame
{

private DrawPanel drawPanel;

public Painter() throws IOException {

	setSize(800,600);
    setTitle("Simple Painter");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);


    //drawPanel
    drawPanel = new DrawPanel();

    //menu
    MyMenuBar menu = new MyMenuBar(drawPanel);
    setJMenuBar(menu);

    //toolbar
    MyToolBar toolbar = new MyToolBar(drawPanel);
    add(toolbar, BorderLayout.NORTH);

    add(drawPanel, BorderLayout.CENTER);

    //drawPanel.add()

    setResizable(true);
    setVisible(true);

  } // end of Painter()


  // --------------------------------------------------


public static void main(String args[]) throws IOException
   {  new Painter();  }


} // end of Painter

