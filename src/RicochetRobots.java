import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;


import javax.swing.Timer;
import javax.swing.*;









public class RicochetRobots extends JFrame
{
	
	static ArrayList<JButton> save = new ArrayList<>();
	static ArrayList<JButton> buttonList = new ArrayList<>();
    static JLabel turn = new JLabel("Player 1");
	static int playerTurn = 0;
	private static Icon[] prevIcon = {new ImageIcon("Images/Tile.png"),new ImageIcon("Images/Tile.png"),new ImageIcon("Images/Tile.png"),new ImageIcon("Images/Tile.png")};
    ArrayList<Piece> pieceList = new ArrayList<>();
    ArrayList<Icon> meepleList = new ArrayList<>();
    int lowestBid = 100;
    int timeStart = 60;
    private Timer timer;
    private int timeLog;
    
    
    
    
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
		
		JButton Bid = new JButton("Bid");
		
        Icon box = new ImageIcon("Images/Tile.png");
        
        
        
        JButton saveGame = new JButton("Save Game");
        saveGame.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        //	new RicochetRobots();
	        	
					Save savestate = new Save("C:\\Users\\taylo\\eclipse-workspace\\Ricochet Robots\\src",buttonList);
				
				
	        	//mainFrame.dispose();
				}});
        
        
        
        
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
        
        meepleList.add(new ImageIcon("Images/GreenMeeple.png"));
        meepleList.add(new ImageIcon("Images/RedMeeple.png"));
        meepleList.add(new ImageIcon("Images/YellowMeeple.png"));
		meepleList.add(new ImageIcon("Images/BlueMeeple.png"));

		for(int i = 0; i<4;i++) buttonList.get(pieceList.get(i).getLoc()).setIcon(meepleList.get(i));
		

        
        
		Ricochet.setLayout(new GridLayout(16,16));
		
		
		mainFrame.add(Ricochet);
		next.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        //	new RicochetRobots();
	        	incTurn();
	        	//mainFrame.dispose();
				}});
		
		up.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
				moveRobot("up");
				// pieceList.get(playerTurn).move(-16);	
				// buttonList = save;
	        	// buttonList.get(pieceList.get(playerTurn).getLoc()).setIcon(meepleList.get(playerTurn));
				}});
		down.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
				moveRobot("down");
	        	// pieceList.get(playerTurn).move(16);
	        	// buttonList = save;
	        	// buttonList.get(pieceList.get(playerTurn).getLoc()).setIcon(meepleList.get(playerTurn));
				}});
		left.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
				moveRobot("left");
	        	// pieceList.get(playerTurn).move(-1);
	        	// buttonList = save;
	        	// buttonList.get(pieceList.get(playerTurn).getLoc()).setIcon(meepleList.get(playerTurn));
				}});
		right.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
				moveRobot("right");
	        	// pieceList.get(playerTurn).move(1);
	        	// buttonList = save;
	        	// buttonList.get(pieceList.get(playerTurn).getLoc()).setIcon(meepleList.get(playerTurn));
				}});
		
		
		Bid.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        	
	        	
	        	JFrame bidFrame = new JFrame("Enter Your Bid");
	    		bidFrame.setSize(400,400);
	    		bidFrame.setLocationRelativeTo(null);
	    		
	    		JPanel bidPanel = new JPanel();
	    		JLabel bidEnter = new JLabel("Enter Bid:");
	    		JLabel currentBids = new JLabel("Other Bids:");
	    		JLabel countdown = new JLabel();
	    		JLabel warn = new JLabel("New bids must be lower than all previous builds, you are Green");
	    		JTextField callBid = new JTextField();
	    		callBid.setColumns(4);
	    		JLabel g = new JLabel();
	    		JLabel r = new JLabel();
	    		JLabel y = new JLabel();
	    		JLabel b = new JLabel();
	    		
	    		timer = new Timer(1000, new ActionListener() {
	    		    public void actionPerformed(ActionEvent evt) {
	    		        if(timeStart == 0){
	    		        	g.setText("Green: " + callBid.getText() + " Time remaining when entered: " + timeLog);
	    		        	info.add(g);
	    		        	r.setText("Red: " + r.getText() + " Time remaining when entered: " + red.getTimeLog());
	    		            info.add(r);
	    		            y.setText("Yellow: " + y.getText() + " Time remaining when entered: " + yellow.getTimeLog());
	    		            info.add(y);
	    		            b.setText("Blue: " + b.getText() + " Time remaining when entered: " + blue.getTimeLog());
	    		            info.add(b);
	    		            warn.setText("Bids moved to Ricochet Robots Frame");
	    		            info.validate();
	    		            callBid.setEnabled(false);
	    		            timer.stop();
	    		            
	    		            
	    		            
	    		        }
	    		        countdown.setText("Countdown: " + timeStart);
	    		        timeStart--;
	    		    }
	    		});
	    		callBid.addActionListener(new ActionListener() {
	    		    public void actionPerformed(ActionEvent e) {
	    		        
	    		        
	    		        
	    		        timer.start();
	    		    }
	    		});
	    		
	    		callBid.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (Integer.parseInt(callBid.getText()) <= lowestBid) {
							lowestBid = Integer.parseInt(callBid.getText());
							red.makeBid(lowestBid, timeStart);
							yellow.makeBid(lowestBid, timeStart-1);
							blue.makeBid(lowestBid, timeStart-2);
							timeLog = timeStart+1;
						}
						
						
						r.setText(Integer.toString(red.getBid()));
						y.setText(Integer.toString(yellow.getBid()));
						b.setText(Integer.toString(blue.getBid()));
						
						
						bidPanel.add(bidEnter);
			    		bidPanel.add(callBid);
			    		bidPanel.add(warn);
						
						
						//bidFrame.dispose();
						
					}
	    			
	    		});
	    		
	    		
	    		bidPanel.add(bidEnter);
	    		bidPanel.add(callBid);
	    		bidPanel.add(currentBids);
	    		bidPanel.add(r);
				bidPanel.add(y);
				bidPanel.add(b);
				bidPanel.add(countdown);
				
	    		bidFrame.setLayout(new GridLayout());
	    		
	    		bidFrame.add(bidPanel);
	    		
	    		
	    		
	    		bidFrame.setLocationRelativeTo(null);
	    		bidFrame.setVisible(true);
				}});
		
		
		info.add(next);
		info.add(turn);
		info.add(up);
		info.add(down);
		info.add(left);
		info.add(right);
		
		info.add(Bid);
		info.add(saveGame);
		info.setLayout(new GridLayout(7,7));
		mainFrame.add(info);
		mainFrame.setSize(1350,675);
		mainFrame.setLayout(new GridLayout(1,2));
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
			
	}


	private void moveRobot(String direction){
		int moveUnits = 0;
		switch(direction){
			case "up": moveUnits=-16;break;
			case "down": moveUnits=16;break;
			case "left": moveUnits=-1;break;
			case "right": moveUnits=1;break;
		}
		int nextLoc = pieceList.get(playerTurn).getLoc()+moveUnits;
		if( (nextLoc<=255 && nextLoc>=0) && !(nextLoc%16==0 && direction=="right") && !(nextLoc%16==15 && direction=="left") ){
			buttonList.get(pieceList.get(playerTurn).getLoc()).setIcon(prevIcon[playerTurn]);
			pieceList.get(playerTurn).move(moveUnits);
			prevIcon[playerTurn] = buttonList.get(pieceList.get(playerTurn).getLoc()).getIcon();
			buttonList = save;
			buttonList.get(pieceList.get(playerTurn).getLoc()).setIcon(meepleList.get(playerTurn));
			moveRobot(direction);
		} else{
			//Out of bounds
		}
		
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
		playerTurn = (playerTurn+1) % 4;
    	
    }
    
    
    //Here is the proto-code for making the map for the complex/simple board
    //I cannot see the icons for whatever reason but here is most of the code
    public static void complex() {
    	buttonList.get(5).setIcon(new ImageIcon("Images/RWall.png"));
    	buttonList.get(8).setIcon(new ImageIcon("Images/RWall.png"));
    	buttonList.get(10).setIcon(new ImageIcon("Images/BWall.png"));
    	buttonList.get(20).setIcon(new ImageIcon("Images/GreenBar.png"));
    	buttonList.get(25).setIcon(new ImageIcon("Images/RWall.png"));
    	buttonList.get(26).setIcon(new ImageIcon("Images/RedPlanet.png"));
    	buttonList.get(33).setIcon(new ImageIcon("Images/BWall.png"));
    	buttonList.get(46).setIcon(new ImageIcon("Images/BlueBar.png"));
    	buttonList.get(47).setIcon(new ImageIcon("Images/BWall.png"));
    	buttonList.get(48).setIcon(new ImageIcon("Images/RWall.png"));
    	buttonList.get(49).setIcon(new ImageIcon("Images/RedBall.png"));
    	buttonList.get(70).setIcon(new ImageIcon("Images/YellowStar.png"));
    	buttonList.get(71).setIcon(new ImageIcon("Images/LWall.png"));
    	buttonList.get(73).setIcon(new ImageIcon("Images/BlueTriangle.png"));
    	buttonList.get(74).setIcon(new ImageIcon("Images/LWall.png"));
    	buttonList.get(80).setIcon(new ImageIcon("Images/BWall.png"));
    	buttonList.get(82).setIcon(new ImageIcon("Images/BWall.png"));
    	buttonList.get(87).setIcon(new ImageIcon("Images/TWall.png"));
    	buttonList.get(89).setIcon(new ImageIcon("Images/TWall.png"));
    	buttonList.get(92).setIcon(new ImageIcon("Images/RWall.png"));
    	buttonList.get(93).setIcon(new ImageIcon("Images/GreenStar.png"));
    	buttonList.get(98).setIcon(new ImageIcon("Images/GreenTriangle.png"));
    	buttonList.get(99).setIcon(new ImageIcon("Images/BluePLanetWithLWall.png"));
    	buttonList.get(109).setIcon(new ImageIcon("Images/YellowBallWithTWall.png"));
    	buttonList.get(110).setIcon(new ImageIcon("Images/LWall.png"));
    	buttonList.get(115).setIcon(new ImageIcon("Images/TWall.png"));	
    	buttonList.get(117).setIcon(new ImageIcon("Images/YellowBar.png"));
    	buttonList.get(119).setIcon(new ImageIcon("Images/TLCentre.png"));
    	buttonList.get(120).setIcon(new ImageIcon("Images/TRCentre.png"));
    	buttonList.get(123).setIcon(new ImageIcon("Images/RedBar.png"));
    	buttonList.get(135).setIcon(new ImageIcon("Images/BLCentre.png"));
    	buttonList.get(136).setIcon(new ImageIcon("Images/BRCentre.png"));
    	buttonList.get(145).setIcon(new ImageIcon("Images/LWall.png"));
    	buttonList.get(146).setIcon(new ImageIcon("Images/YellowTriangle.png"));
    	buttonList.get(151).setIcon(new ImageIcon("Images/BWall.png"));
    	buttonList.get(154).setIcon(new ImageIcon("Images/YellowPlanet.png"));
    	buttonList.get(155).setIcon(new ImageIcon("Images/LWall.png"));
    	buttonList.get(160).setIcon(new ImageIcon("Images/BWall.png"));
    	buttonList.get(162).setIcon(new ImageIcon("Images/TWall.png"));
    	buttonList.get(167).setIcon(new ImageIcon("Images/VortexRightWall.png"));
    	buttonList.get(170).setIcon(new ImageIcon("Images/TWall.png"));
    	buttonList.get(172).setIcon(new ImageIcon("Images/BWall.png"));
    	buttonList.get(188).setIcon(new ImageIcon("Images/RedTriangle.png"));
    	buttonList.get(189).setIcon(new ImageIcon("Images/GreenBallLWall.png"));
    	buttonList.get(195).setIcon(new ImageIcon("Images/Greenplanet.png"));
    	buttonList.get(196).setIcon(new ImageIcon("Images/LWall.png"));
    	buttonList.get(199).setIcon(new ImageIcon("Images/GreenBar.png"));
    	buttonList.get(202).setIcon(new ImageIcon("Images/YellowBar.png"));
    	buttonList.get(206).setIcon(new ImageIcon("Images/TWall.png"));
    	buttonList.get(208).setIcon(new ImageIcon("Images/BWall.png"));
    	buttonList.get(210).setIcon(new ImageIcon("Images/RedBar.png"));
    	buttonList.get(211).setIcon(new ImageIcon("Images/RWall.png"));
    	buttonList.get(212).setIcon(new ImageIcon("Images/BlueBall.png"));
    	buttonList.get(214).setIcon(new ImageIcon("Images/BWall.png"));
    	buttonList.get(217).setIcon(new ImageIcon("Images/RWall.png"));
    	buttonList.get(218).setIcon(new ImageIcon("Images/BlueStarTWall.png"));
    	buttonList.get(230).setIcon(new ImageIcon("Images/RedStar.png"));
    	buttonList.get(231).setIcon(new ImageIcon("Images/LWall.png"));
    	buttonList.get(236).setIcon(new ImageIcon("Images/BlueBar.png"));
    	buttonList.get(247).setIcon(new ImageIcon("Images/RWall.png"));
    	buttonList.get(251).setIcon(new ImageIcon("Images/RWall.png"));
    	
    	
    	
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
