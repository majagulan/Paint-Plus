
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;


public class MyToolBar extends JToolBar 
							implements ActionListener 
{
	//constants;
	private JButton btnClear, btnText;
	private JCheckBox btnBold, btnItalic, btnEraser;
	private DrawPanel drawPanel;
	private String myText;
	
	private static final int TEXT = 5;
	private static final int ERASER = 6;
	
	
	public MyToolBar(DrawPanel dp) throws IOException
	{
		super(SwingConstants.HORIZONTAL);
		drawPanel = dp;
		initToolBar();
	}
	
	private void initToolBar() throws IOException 
	{		
		
		addSeparator();
		
		//CLEAR
		btnClear = new JButton();
	    btnClear.setToolTipText("Clear");
	    btnClear.setIcon(new ImageIcon("stamps/clear.jpeg"));
	    btnClear.addActionListener(this);
	    btnClear.setMnemonic(KeyEvent.VK_0);
	    add(btnClear);
	    
	    addSeparator();
	    addSeparator();
	    addSeparator();
	    addSeparator();
	    
	    
	    //ERASER
	    btnEraser = new JCheckBox();
	    btnEraser.setToolTipText("Eraser");
	    btnEraser.addActionListener(this);
	    btnEraser.setMnemonic(KeyEvent.VK_E);
	    add(btnEraser);
	    
	    addSeparator();
	    
	    BufferedImage myPicture3 = ImageIO.read(new File("stamps/eraser.png"));
	    JLabel picLabel3 = new JLabel(new ImageIcon(myPicture3));
	    add(picLabel3);
	    
	    
	    addSeparator();
	    addSeparator();
	    addSeparator();
	    addSeparator();
	
	    
	    //TEXT
	    btnText = new JButton();
	    btnText.setToolTipText("Text");
	    btnText.setIcon(new ImageIcon("stamps/text.png"));
	    btnText.addActionListener(this);
	    btnText.setMnemonic(KeyEvent.VK_T);
	    add(btnText);
	    
	    
	    addSeparator();
	    addSeparator();
	    addSeparator();
	    addSeparator();
	    
	    
	    //BOLD
	    btnBold = new JCheckBox();
	    btnBold.setToolTipText("Bold");
	    btnBold.addActionListener(this);
	    btnBold.setMnemonic(KeyEvent.VK_B);
	    add(btnBold);
	    
	    
	    addSeparator();
	    
	    BufferedImage myPicture1 = ImageIO.read(new File("stamps/bold.png"));
	    JLabel picLabel1 = new JLabel(new ImageIcon(myPicture1));
	    add(picLabel1);
	    
	    addSeparator();
	    addSeparator();
	    addSeparator();
	    addSeparator();
	    
	    
	    //ITALIC
	    btnItalic = new JCheckBox();
	    btnItalic.setToolTipText("Text");
	    btnItalic.addActionListener(this);
	    btnItalic.setMnemonic(KeyEvent.VK_I);
	    add(btnItalic);
	    
	    addSeparator();
	    
	    BufferedImage myPicture2 = ImageIO.read(new File("stamps/italic.jpg"));
	    JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
	    add(picLabel2);
	    
	    
	    setFloatable(true);  
	    setBackground(new Color(255,255,204));
	}
	
	
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
		
		// clear button
		if (source == btnClear) {
			drawPanel.clear();
		    playSound("sound_eff/clear.wav");
		}
		
		//eraser button
		else if (source == btnEraser) {
			if (btnEraser.isSelected() == true) {	//if it is checked		    	
				drawPanel.setOldShapeType();
				drawPanel.setOldColour();
				drawPanel.setShape(ERASER);
			    playSound("sound_eff/shapes.wav");
			}
			else if (btnEraser.isSelected() == false)	//if it is not checked
			{
				drawPanel.setNextShapeType();
				drawPanel.setNextColour();
			}
		}
		
		
		// text button
		else if (source == btnText) 
		{
		    playSound("sound_eff/text.wav");
		    JFrame frame = new JFrame("JOptionPane showMessageDialog");
		    myText = JOptionPane.showInputDialog(frame, "Enter your text here: ");	  
		    drawPanel.setCurrString(myText);
		    drawPanel.setShape(TEXT);
		}
			
		// bold checkbox
		else if (source == btnBold) {
			drawPanel.setBold( btnBold.isSelected() );
			playSound("sound_eff/italic&bold.wav");
		}
		// italics checkbox
		else if (source == btnItalic) { 
			drawPanel.setItalic( btnItalic.isSelected() );
			playSound("sound_eff/italic&bold.wav");
		}
				
	    else
	    	System.out.println("Unrecognized control panel event: " + e);
	}
	
    public String getText() {
    	return myText;
    }
		
}

