
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
public class RichochetRobots extends JFrame
{
	
	ArrayList<JButton> buttonList = new ArrayList<>();
    
    public RichochetRobots () 
    {
		JFrame mainFrame = new JFrame("Ricochet Robots");
		mainFrame.setSize(800,800);
		mainFrame.setLocationRelativeTo(null);
		JPanel Ricochet = new JPanel();
        Icon box = new ImageIcon(new ImageIcon("resources/heart.png").getImage().getScaledInstance(10, 10, java.awt.Image.SCALE_SMOOTH));
        
        for(int i = 0; i < 256; i++) 
        {
			
			JButton button = new JButton(box);
		    buttonList.add(button);
		    
		}
		
		
        for(int i = 0; i < 256; i++) 
        {
		    Ricochet.add(buttonList.get(i));
		}
		Ricochet.setLayout(new GridLayout(16,16));
		mainFrame.add(Ricochet);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
			
    }
    

    public static void main ( String [] args)
    {
		new RichochetRobots ();
	
    } 
}
