/* The controls panel consists of a vertical list of:
     - shape radio buttons: freehand (the default), oval, rectangle, line

     - a checkbox for filling the shapes (on by default)

     - colour radio buttons: black (the default), green, blue, white
         - white is the same colour as the drawing background so
           acts as an erase colour

     - a "clear" button for the entire drawing area
*/

import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;


public class MyMenuBar extends JMenuBar
                            implements ActionListener
{

  // shape drawing constants
  private static final int FREEHAND = 0;
  private static final int OVAL = 1;
  private static final int RECTANGLE = 2;
  private static final int TRIANGLE = 3;
  private static final int LINE = 4;

  private static final float THICK1 = 4.0f;
  private static final float THICK2 = 5.0f;
  private static final float THICK3 = 6.0f;
  private static final float THICK4 = 7.0f;
  private static final float THICK5 = 8.0f;

  private JRadioButtonMenuItem rmiFreehand, rmiOval, rmiRectangle, rmiTriangle, rmiLine;
  private JRadioButtonMenuItem rmit1, rmit2, rmit3, rmit4, rmit5;
  private JRadioButtonMenuItem rmiBlack, rmiRed, rmiGreen, rmiBlue, rmiWhite,
  			rmiYellow, rmiMagenta, rmiOrange, rmiPink;
  private JRadioButtonMenuItem f10, f15, f20, f25, f30, f35, f40, f45, f50;
  private JRadioButtonMenuItem f1, f2, f3, f4, f5;
  private JCheckBoxMenuItem cmiFilled;
  private JCheckBoxMenuItem cmiInterrupted;

  private DrawPanel drawPanel;    // the drawing surface


  public MyMenuBar(DrawPanel dp)
  { drawPanel = dp;
    initMenu();

  }  // end of MyMenuBar()



  private void initMenu()
  {
	  JMenu shape = new JMenu("Shape");
	  JMenu size = new JMenu("Line size");
	  JMenu colours = new JMenu("Colours");
	  JMenu fontSize = new JMenu("Font size");
	  JMenu fonts = new JMenu("Font");


	 //SHAPES
	  ButtonGroup bg1 = new ButtonGroup();
	  rmiFreehand = new JRadioButtonMenuItem("Freehand", true);
	  rmiOval = new JRadioButtonMenuItem("Oval", false);
	  rmiRectangle = new JRadioButtonMenuItem("Rectangle", false);
	  rmiTriangle = new JRadioButtonMenuItem("Triangle", false);
	  rmiLine = new JRadioButtonMenuItem("Line", false);

	  bg1.add(rmiFreehand);
	  bg1.add(rmiOval);
	  bg1.add(rmiRectangle);
	  bg1.add(rmiTriangle);
	  bg1.add(rmiLine);


	  rmiFreehand.addActionListener(this);
	  rmiOval.addActionListener(this);
	  rmiRectangle.addActionListener(this);
	  rmiTriangle.addActionListener(this);
	  rmiLine.addActionListener(this);


	  shape.add(rmiFreehand);
	  shape.add(rmiOval);
	  shape.add(rmiRectangle);
	  shape.add(rmiTriangle);
	  shape.add(rmiLine);


	  shape.addSeparator();

	  //FILLED
	  cmiFilled = new JCheckBoxMenuItem("Filled?", true);
	  cmiFilled.addActionListener(this);
	  shape.add(cmiFilled);

	  //THICKNESS
	  ButtonGroup bg2 = new ButtonGroup();
	  rmit1 = new JRadioButtonMenuItem("1", true);
	  rmit2 = new JRadioButtonMenuItem("5");
	  rmit3 = new JRadioButtonMenuItem("10");
	  rmit4 = new JRadioButtonMenuItem("15");
	  rmit5 = new JRadioButtonMenuItem("20");

	  //mnemonics
	  rmit1.setMnemonic(KeyEvent.VK_1);
	  rmit2.setMnemonic(KeyEvent.VK_2);
	  rmit3.setMnemonic(KeyEvent.VK_3);
	  rmit4.setMnemonic(KeyEvent.VK_4);
	  rmit5.setMnemonic(KeyEvent.VK_5);

	  bg2.add(rmit1);
	  bg2.add(rmit2);
	  bg2.add(rmit3);
	  bg2.add(rmit4);
	  bg2.add(rmit5);

	  rmit1.addActionListener(this);
	  rmit2.addActionListener(this);
	  rmit3.addActionListener(this);
	  rmit4.addActionListener(this);
	  rmit5.addActionListener(this);

	  size.add(rmit1);
	  size.add(rmit2);
	  size.add(rmit3);
	  size.add(rmit4);
	  size.add(rmit5);

	  size.addSeparator();

	  //INTERRUPTED
	  cmiInterrupted = new JCheckBoxMenuItem("Interrupted?", false);
	  cmiInterrupted.addActionListener(this);
	  //mnemonics
	  cmiInterrupted.setMnemonic(KeyEvent.VK_I);

      size.add(cmiInterrupted);

      //COLOURS
      ButtonGroup bg3 = new ButtonGroup();
      rmiBlack = new JRadioButtonMenuItem("Black", true);
      rmiRed = new JRadioButtonMenuItem("Red");
      rmiGreen = new JRadioButtonMenuItem("Green");
      rmiBlue = new JRadioButtonMenuItem("Blue");
      rmiWhite = new JRadioButtonMenuItem("White");
      rmiYellow = new JRadioButtonMenuItem("Yellow");
      rmiMagenta = new JRadioButtonMenuItem("Magenta");
      rmiOrange = new JRadioButtonMenuItem("Orange");
      rmiPink = new JRadioButtonMenuItem("Pink");

      bg3.add(rmiBlack);
      bg3.add(rmiRed);
      bg3.add(rmiGreen);
      bg3.add(rmiBlue);
      bg3.add(rmiWhite);
      bg3.add(rmiYellow);
      bg3.add(rmiMagenta);
      bg3.add(rmiOrange);
      bg3.add(rmiPink);

      rmiBlack.addActionListener(this);
      rmiRed.addActionListener(this);
      rmiGreen.addActionListener(this);
      rmiBlue.addActionListener(this);
      rmiWhite.addActionListener(this);
      rmiYellow.addActionListener(this);
      rmiMagenta.addActionListener(this);
      rmiOrange.addActionListener(this);
      rmiPink.addActionListener(this);

      colours.add(rmiBlack);
      colours.add(rmiRed);
      colours.add(rmiGreen);
      colours.add(rmiBlue);
      colours.add(rmiWhite);
      colours.add(rmiYellow);
      colours.add(rmiMagenta);
      colours.add(rmiOrange);
      colours.add(rmiPink);

      //mnemonics
      rmiRed.setMnemonic(KeyEvent.VK_R);
      rmiGreen.setMnemonic(KeyEvent.VK_G);
      rmiBlue.setMnemonic(KeyEvent.VK_B);
      rmiWhite.setMnemonic(KeyEvent.VK_W);
      rmiYellow.setMnemonic(KeyEvent.VK_Y);
      rmiMagenta.setMnemonic(KeyEvent.VK_M);
      rmiOrange.setMnemonic(KeyEvent.VK_O);
      rmiPink.setMnemonic(KeyEvent.VK_P);


      //FONT SIZE
      ButtonGroup bg4 = new ButtonGroup();
      f10 = new JRadioButtonMenuItem("10");
      f15 = new JRadioButtonMenuItem("15");
      f20 = new JRadioButtonMenuItem("20", true);
      f25 = new JRadioButtonMenuItem("25");
      f30 = new JRadioButtonMenuItem("30");
      f35 = new JRadioButtonMenuItem("35");
      f40 = new JRadioButtonMenuItem("40");
      f45 = new JRadioButtonMenuItem("45");
      f50 = new JRadioButtonMenuItem("50");

      bg4.add(f10);
      bg4.add(f15);
      bg4.add(f20);
      bg4.add(f25);
      bg4.add(f30);
      bg4.add(f35);
      bg4.add(f40);
      bg4.add(f45);
      bg4.add(f50);

      f10.addActionListener(this);
      f15.addActionListener(this);
      f20.addActionListener(this);
      f25.addActionListener(this);
      f30.addActionListener(this);
      f35.addActionListener(this);
      f40.addActionListener(this);
      f45.addActionListener(this);
      f50.addActionListener(this);

      fontSize.add(f10);
      fontSize.add(f15);
      fontSize.add(f20);
      fontSize.add(f25);
      fontSize.add(f30);
      fontSize.add(f35);
      fontSize.add(f40);
      fontSize.add(f45);
      fontSize.add(f50);

      //FONT
      ButtonGroup bg5 = new ButtonGroup();
      f1 = new JRadioButtonMenuItem("Serif", true);
      f2 = new JRadioButtonMenuItem("Monospaced");
      f3 = new JRadioButtonMenuItem("SansSerif");
      f4 = new JRadioButtonMenuItem("Dialog");
      f5 = new JRadioButtonMenuItem("DialogInput");

      bg5.add(f1);
      bg5.add(f2);
      bg5.add(f3);
      bg5.add(f4);
      bg5.add(f5);

      f1.addActionListener(this);
      f2.addActionListener(this);
      f3.addActionListener(this);
      f4.addActionListener(this);
      f5.addActionListener(this);

      fonts.add(f1);
      fonts.add(f2);
      fonts.add(f3);
      fonts.add(f4);
      fonts.add(f5);



      add(shape);
      add(size);
	  add(colours);
	  add(fontSize);
	  add(fonts);


  }  //end of initMenu()


  //SOUND WHEN SELECTING ANYTHING

  private void playSound(String soundName)
  {
    try
    {
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
    Clip clip = AudioSystem.getClip( );
    clip.open(audioInputStream);
    clip.start( );
    }
    catch(Exception ex)
    {
      System.out.println("Error with playing sound.");
      ex.printStackTrace( );
    }

 }


public void actionPerformed(ActionEvent e)
  {
    Object source = e.getSource();

    if (source == rmiFreehand) {     // freehand shape
      drawPanel.setShape(FREEHAND);
      playSound("sound_eff/shapes.wav");
    }
    else if (source == rmiOval) {   // oval shape
      drawPanel.setShape(OVAL);
      playSound("sound_eff/shapes.wav");
    }
    else if (source == rmiRectangle) {   // rectangle shape
      drawPanel.setShape(RECTANGLE);
      playSound("sound_eff/shapes.wav");
    }
    else if (source == rmiLine) {    // line
      drawPanel.setShape(LINE);
      playSound("sound_eff/shapes.wav");
    }
    else if (source == rmiTriangle) {	  // triangle shape
    	drawPanel.setShape(TRIANGLE);
        playSound("sound_eff/shapes.wav");
    }
    //
    else if (source == cmiFilled) {  // filled checkbox
      drawPanel.setFilled( cmiFilled.isSelected() );
      playSound("sound_eff/fill&inter.wav");
    }
    //
    else if (source == cmiInterrupted) {	//interrupted checkbox
    	drawPanel.setInterrupted( cmiInterrupted.isSelected() );
        playSound("sound_eff/fill&inter.wav");
    }
    //
    else if (source == rmit1) {   //thickness
    	drawPanel.setThickness(THICK1);
        playSound("sound_eff/thick.wav");
    }
    else if (source == rmit2) {
    	drawPanel.setThickness(THICK2);
        playSound("sound_eff/thick.wav");
    }
    else if (source == rmit3) {
    	drawPanel.setThickness(THICK3);
        playSound("sound_eff/thick.wav");
    }
    else if (source == rmit4) {
    	drawPanel.setThickness(THICK4);
        playSound("sound_eff/thick.wav");
    }
    else if (source == rmit5) {
    	drawPanel.setThickness(THICK5);
        playSound("sound_eff/thick.wav");
    }
    //
    else if (source == rmiBlack) {   // black colour
      drawPanel.setColour(Color.BLACK);
      playSound("sound_eff/colour.wav");
    }
    else if (source == rmiRed) {    // red
      drawPanel.setColour(Color.RED);
      playSound("sound_eff/colour.wav");
    }
    else if (source == rmiGreen) {   // green
      drawPanel.setColour(Color.GREEN);
      playSound("sound_eff/colour.wav");
    }
    else if (source == rmiBlue) {   // blue
      drawPanel.setColour(Color.BLUE);
      playSound("sound_eff/colour.wav");
    }
    else if (source == rmiWhite) {    // white
      drawPanel.setColour(Color.WHITE);
      playSound("sound_eff/colour.wav");
    }
    else if (source == rmiYellow) {    // yellow
        drawPanel.setColour(Color.YELLOW);
        playSound("sound_eff/colour.wav");
    }
    else if (source == rmiMagenta) {    // magenta
        drawPanel.setColour(Color.MAGENTA);
        playSound("sound_eff/colour.wav");
    }
    else if (source == rmiOrange) {   // orange
        drawPanel.setColour(Color.ORANGE);
        playSound("sound_eff/colour.wav");
    }
    else if (source == rmiPink) {    // pink
        drawPanel.setColour(Color.PINK);
        playSound("sound_eff/colour.wav");
    }
    //
    else if (source == f10) {
    	drawPanel.setFontSize(10);
        playSound("sound_eff/font&size.wav");
    }
    else if (source == f15) {
    	drawPanel.setFontSize(15);
        playSound("sound_eff/font&size.wav");
    }
    else if (source == f20) {
    	drawPanel.setFontSize(20);
        playSound("sound_eff/font&size.wav");
    }
    else if (source == f25) {
    	drawPanel.setFontSize(25);
        playSound("sound_eff/font&size.wav");
    }
    else if (source == f30) {
    	drawPanel.setFontSize(30);
        playSound("sound_eff/font&size.wav");
    }
    else if (source == f35) {
    	drawPanel.setFontSize(35);
        playSound("sound_eff/font&size.wav");
    }
    else if (source == f40) {
    	drawPanel.setFontSize(40);
        playSound("sound_eff/font&size.wav");
    }
    else if (source == f45) {
    	drawPanel.setFontSize(45);
        playSound("sound_eff/font&size.wav");
    }
    else if (source == f50) {
    	drawPanel.setFontSize(50);
        playSound("sound_eff/font&size.wav");
    }
    //
    else if (source == f1) {
    	drawPanel.setFont("Serif");
        playSound("sound_eff/font&size.wav");
    }
    else if (source == f2) {
    	drawPanel.setFont("Monospaced");
        playSound("sound_eff/font&size.wav");
    }
    else if (source == f3) {
    	drawPanel.setFont("SansSerif");
        playSound("sound_eff/font&size.wav");
    }
    else if (source == f4) {
    	drawPanel.setFont("Dialog");
        playSound("sound_eff/font&size.wav");
    }
    else if (source == f5) {
    	drawPanel.setFont("DialogInput");
        playSound("sound_eff/font&size.wav");
    }
    //
    else
      System.out.println("Unrecognized control panel event: " + e);
  }  // end of actionPerformed()


}  // end of MyMenuBar class
