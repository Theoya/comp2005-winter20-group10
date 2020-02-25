import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
public class RicochetRobots extends JFrame{
	
	ArrayList<JButton> buttonList = new ArrayList<>();
    
	public RicochetRobots() {
		JFrame mainFrame = new JFrame("Ricochet Robots");
		mainFrame.setSize(800,800);
		mainFrame.setLocationRelativeTo(null);
		JPanel Ricochet = new JPanel();
	    
		
		for(int i = 0; i < 256; i++) {
			
			JButton button = new JButton();
			button.setIcon(new ImageIcon("C:\\Users\\taylo\\eclipse-workspace\\Ricochet Robots\\src\\Images\\Tile.png"));
		    buttonList.add(button);
		    //buttonLayout.add(button);}
		}
		
		
		for(int i = 0; i < 256; i++) {
		    Ricochet.add(buttonList.get(i));
		}
		Ricochet.setLayout(new GridLayout(16,16));
		mainFrame.add(Ricochet);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		
		
	}
	public static void main ( String [] args){
		new RicochetRobots();
	
	
}}
