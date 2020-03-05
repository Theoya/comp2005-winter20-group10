import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
public class RicochetRobots extends JFrame
{
	
	static ArrayList<JButton> save = new ArrayList<>();
	static ArrayList<JButton> buttonList = new ArrayList<>();
    static JLabel turn = new JLabel("Player 1");
    int playerTurn = 0;
    ArrayList<Piece> pieceList = new ArrayList<>();
    ArrayList<Icon> meepleList = new ArrayList<>();
    
    
    
    public RicochetRobots() 
    {
		JFrame mainFrame = new JFrame("Ricochet Robots");
		mainFrame.setSize(800,800);
		mainFrame.setLocationRelativeTo(null);
		JPanel Ricochet = new JPanel();
		JButton next = new JButton();
		JButton up = new JButton("up");
		JButton down = new JButton("down");
		JButton left = new JButton("left");
		JButton right = new JButton("right");
		
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
        
        JPanel info = new JPanel();
        
        
        Piece green = new Piece(56,1);
        Piece red = new Piece(80,2);
        Piece yellow = new Piece(180,3);
        Piece blue = new Piece(200,4);
        pieceList.add(green);
        pieceList.add(red);
        pieceList.add(yellow);
        pieceList.add(blue);
        
        meepleList.add(new ImageIcon("GreenMeeple.png"));
        meepleList.add(new ImageIcon("RedMeeple.png"));
        meepleList.add(new ImageIcon("YellowMeeple.png"));
        meepleList.add(new ImageIcon("BlueMeeple.png"));
        
        
		Ricochet.setLayout(new GridLayout(16,16));
		
		
		mainFrame.add(Ricochet);
		next.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	new RicochetRobots();
	        	incTurn();
	        	mainFrame.dispose();
				}});
		
		up.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	pieceList.get(playerTurn).move(-16);
	        	buttonList = save;
	        	buttonList.get(pieceList.get(playerTurn).getLoc()).setIcon(meepleList.get(playerTurn));
				}});
		down.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	pieceList.get(playerTurn).move(16);
	        	buttonList = save;
	        	buttonList.get(pieceList.get(playerTurn).getLoc()).setIcon(meepleList.get(playerTurn));
				}});
		left.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	pieceList.get(playerTurn).move(-1);
	        	buttonList = save;
	        	buttonList.get(pieceList.get(playerTurn).getLoc()).setIcon(meepleList.get(playerTurn));
				}});
		right.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	pieceList.get(playerTurn).move(1);
	        	buttonList = save;
	        	buttonList.get(pieceList.get(playerTurn).getLoc()).setIcon(meepleList.get(playerTurn));
				}});
		
		info.add(next);
		info.add(turn);
		info.add(up);
		info.add(down);
		info.add(left);
		info.add(right);
		
		mainFrame.add(info);
		mainFrame.setSize(1350,675);
		mainFrame.setLayout(new GridLayout(1,2));
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
			
    }
    private static void incTurn() {
    	String t = turn.getText();
    	if (t == "Player 1"){
    		turn.setText("Player 2");
    	}
    	else if (t == "Player 2"){
    		turn.setText("Player 3");
    	}
    	else if (t == "Player 3"){
    		turn.setText("Player 4");
    	}
    	else if (t == "Player 4"){
    		turn.setText("Player 1");
    	}
    	
    }
    
    
    //Here is the proto-code for making the map for the complex/simple board
    //I cannot see the icons for whatever reason but here is most of the code
    public static void complex() {
    	buttonList.get(5).setIcon(new ImageIcon("RWall.png"));
    	buttonList.get(8).setIcon(new ImageIcon("RWall.png"));
    	buttonList.get(10).setIcon(new ImageIcon("BWall.png"));
    	buttonList.get(20).setIcon(new ImageIcon("GreenBar.png"));
    	buttonList.get(25).setIcon(new ImageIcon("RWall.png"));
    	buttonList.get(26).setIcon(new ImageIcon("RedPlanet.png"));
    	buttonList.get(33).setIcon(new ImageIcon("BWall.png"));
    	buttonList.get(46).setIcon(new ImageIcon("BlueBar.png"));
    	buttonList.get(47).setIcon(new ImageIcon("BWall.png"));
    	buttonList.get(48).setIcon(new ImageIcon("RWall.png"));
    	buttonList.get(49).setIcon(new ImageIcon("RedBall.png"));
    	buttonList.get(70).setIcon(new ImageIcon("YellowStar.png"));
    	buttonList.get(71).setIcon(new ImageIcon("LWall.png"));
    	buttonList.get(73).setIcon(new ImageIcon("BlueTriangle.png"));
    	buttonList.get(74).setIcon(new ImageIcon("LWall.png"));
    	buttonList.get(80).setIcon(new ImageIcon("BWall.png"));
    	buttonList.get(82).setIcon(new ImageIcon("BWall.png"));
    	buttonList.get(87).setIcon(new ImageIcon("TWall.png"));
    	buttonList.get(89).setIcon(new ImageIcon("TWall.png"));
    	buttonList.get(92).setIcon(new ImageIcon("RWall.png"));
    	buttonList.get(93).setIcon(new ImageIcon("GreenStar.png"));
    	buttonList.get(98).setIcon(new ImageIcon("GreenTriangle.png"));
    	buttonList.get(99).setIcon(new ImageIcon("BluePLanetWithLWall.png"));
    	buttonList.get(109).setIcon(new ImageIcon("YellowBallWithTWall.png"));
    	buttonList.get(110).setIcon(new ImageIcon("LWall.png"));
    	buttonList.get(115).setIcon(new ImageIcon("TWall.png"));	
    	buttonList.get(117).setIcon(new ImageIcon("YellowBar.png"));
    	buttonList.get(119).setIcon(new ImageIcon("TLCentre.png"));
    	buttonList.get(120).setIcon(new ImageIcon("TRCentre.png"));
    	buttonList.get(123).setIcon(new ImageIcon("RedBar.png"));
    	buttonList.get(135).setIcon(new ImageIcon("BLCentre.png"));
    	buttonList.get(136).setIcon(new ImageIcon("BRCentre.png"));
    	buttonList.get(145).setIcon(new ImageIcon("LWall.png"));
    	buttonList.get(146).setIcon(new ImageIcon("YellowTriangle.png"));
    	buttonList.get(151).setIcon(new ImageIcon("BWall.png"));
    	buttonList.get(154).setIcon(new ImageIcon("YellowPlanet.png"));
    	buttonList.get(155).setIcon(new ImageIcon("LWall.png"));
    	buttonList.get(160).setIcon(new ImageIcon("BWall.png"));
    	buttonList.get(162).setIcon(new ImageIcon("TWall.png"));
    	buttonList.get(167).setIcon(new ImageIcon("VortexRightWall.png"));
    	buttonList.get(170).setIcon(new ImageIcon("TWall.png"));
    	buttonList.get(172).setIcon(new ImageIcon("BWall.png"));
    	buttonList.get(188).setIcon(new ImageIcon("RedTriangle.png"));
    	buttonList.get(189).setIcon(new ImageIcon("GreenBallLWall.png"));
    	buttonList.get(195).setIcon(new ImageIcon("Greenplanet.png"));
    	buttonList.get(196).setIcon(new ImageIcon("LWall.png"));
    	buttonList.get(199).setIcon(new ImageIcon("GreenBar.png"));
    	buttonList.get(202).setIcon(new ImageIcon("YellowBar.png"));
    	buttonList.get(206).setIcon(new ImageIcon("TWall.png"));
    	buttonList.get(208).setIcon(new ImageIcon("BWall.png"));
    	buttonList.get(210).setIcon(new ImageIcon("RedBar.png"));
    	buttonList.get(211).setIcon(new ImageIcon("RWall.png"));
    	buttonList.get(212).setIcon(new ImageIcon("BlueBall.png"));
    	buttonList.get(214).setIcon(new ImageIcon("BWall.png"));
    	buttonList.get(217).setIcon(new ImageIcon("RWall.png"));
    	buttonList.get(218).setIcon(new ImageIcon("BlueStarTWall.png"));
    	buttonList.get(230).setIcon(new ImageIcon("RedStar.png"));
    	buttonList.get(231).setIcon(new ImageIcon("LWall.png"));
    	buttonList.get(236).setIcon(new ImageIcon("BlueBar.png"));
    	buttonList.get(247).setIcon(new ImageIcon("RWall.png"));
    	buttonList.get(251).setIcon(new ImageIcon("RWall.png"));
    	
    	
    	
    }
    

    

	public static void main ( String [] args){
		//Size choosing
				JFrame intro = new JFrame("Choose gamemode");
				JPanel icky = new JPanel();
				JButton simple = new JButton("Simple");JButton complex = new JButton("Complex");
				
				simple.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent arg0) {
			        	new RicochetRobots();
			        	intro.dispose();
			        	
						}});
				complex.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent arg0) {
			        	new RicochetRobots();
			        	complex();
			        	save = buttonList;
			        	intro.dispose();
						}});
				
				
				intro.setSize(500,200);
				icky.setLayout(new GridLayout(5,5));
				//adds buttons to Label
				icky.add(simple);
				icky.add(complex);
				intro.add(icky);
				intro.setLocationRelativeTo(null);
				intro.setVisible(true);
				
				
			
}}
