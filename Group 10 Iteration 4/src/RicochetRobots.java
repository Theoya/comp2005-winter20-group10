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
	private static ImageIcon[] prevIcon = {new ImageIcon("Images/Tile.PNG"),new ImageIcon("Images/Tile.PNG"),new ImageIcon("Images/Tile.PNG"),new ImageIcon("Images/Tile.PNG")};
    static ArrayList<Piece> pieceList = new ArrayList<>();
    static ArrayList<Icon> meepleList = new ArrayList<>();
    int lowestBid = 100;
    int i = 0;
    int timeStart = 1;
    private Timer timer;
	private int timeLog;

	private static Token token = new Token();
	private String currChip;
	static JTextField callBid = new JTextField();
	static Piece green;
	static Piece red;
	static Piece yellow;
	static Piece blue;
    
    
    
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
                JButton redRobot = new JButton("red");
                JButton yellowRobot = new JButton("yellow");
                JButton greenRobot = new JButton("green");
                JButton blueRobot = new JButton("blue");
		
        Icon box = new ImageIcon("Images/Tile.png");
        
        
        
        JButton saveGame = new JButton("Save Game");
        saveGame.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
	        //	new RicochetRobots();
	        	
					Save savestate = new Save(System.getProperty("user.dir"),buttonList);
				
				
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
        

        // pieceList.add(green);
        // pieceList.add(red);
        // pieceList.add(yellow);
		// pieceList.add(blue);
        
        meepleList.add(new ImageIcon("Images/GreenMeeple.PNG"));
        meepleList.add(new ImageIcon("Images/RedMeeple.PNG"));
        meepleList.add(new ImageIcon("Images/YellowMeeple.PNG"));
		meepleList.add(new ImageIcon("Images/BlueMeeple.PNG"));

		

        
        
		Ricochet.setLayout(new GridLayout(16,16)); //setting grid
		
		
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
		
		redRobot.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				chooseRobot("red");
				
				}});
		yellowRobot.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
				chooseRobot("blue");
	        	
				}});
		blueRobot.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
				chooseRobot("yellow");
	        	
				}});
		greenRobot.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {
				chooseRobot("green");
	        
				}});

		Bid.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent arg0) {

				currChip = Token.getToken();
	        	JFrame bidFrame = new JFrame("Enter Your Bid");
	    		bidFrame.setSize(400,400);
	    		bidFrame.setLocationRelativeTo(null);
	    		
	    		JPanel bidPanel = new JPanel();
	    		JLabel bidEnter = new JLabel("Enter Bid:");
	    		JLabel currentBids = new JLabel("Other Bids:");
	    		JLabel countdown = new JLabel();
	    		JLabel warn = new JLabel("New bids must be lower than all previous builds, you are Green");
	    		
	    		callBid.setColumns(4);
	    		JLabel p1 = new JLabel();
	    		JLabel p2 = new JLabel();
	    		JLabel p3 = new JLabel();
				JLabel p4 = new JLabel();
				JLabel chip = new JLabel();
	    		
	    		timer = new Timer(1000, new ActionListener() {
	    		    public void actionPerformed(ActionEvent evt) {
	    		        if(timeStart == 0){
	    		        	p1.setText("Green: " + callBid.getText() + " Time remaining when entered: " + timeLog);
	    		        	info.add(p1);
	    		        	p2.setText("Red: " + p2.getText() + " Time remaining when entered: " + red.getTimeLog());
	    		            info.add(p2);
	    		            p3.setText("Yellow: " + p3.getText() + " Time remaining when entered: " + yellow.getTimeLog());
	    		            info.add(p3);
	    		            p4.setText("Blue: " + p4.getText() + " Time remaining when entered: " + blue.getTimeLog());
							info.add(p4);
							chip.setText("Target token : "+ currChip);
							info.add(chip);
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
						
						
						p2.setText(Integer.toString(red.getBid()));
						p3.setText(Integer.toString(yellow.getBid()));
						p4.setText(Integer.toString(blue.getBid()));
						
						
						bidPanel.add(bidEnter);
			    		bidPanel.add(callBid);
			    		bidPanel.add(warn);
						
						
						//bidFrame.dispose();
						
					}
	    			
	    		});
	    		
	    		
	    		bidPanel.add(bidEnter);
	    		bidPanel.add(callBid);
	    		bidPanel.add(currentBids);
	    		bidPanel.add(p2);
				bidPanel.add(p3);
				bidPanel.add(p4);
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
                info.add(redRobot);
                info.add(blueRobot);
                info.add(yellowRobot);
                info.add(greenRobot);
		
		info.add(Bid);
		info.add(saveGame);
		info.setLayout(new GridLayout(7,7));
		mainFrame.add(info);
		mainFrame.setSize(1350,675);
		mainFrame.setLayout(new GridLayout(1,2));
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
			
	}


      private void chooseRobot(String color){
		switch(color){
			case "red": playerTurn =1;break;
			case "yellow": playerTurn=3;break;
			case "green": playerTurn=0;break;
			case "blue": playerTurn=2;break;
		}
			

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
		int bid = Integer.parseInt(callBid.getText()) - i;
                // int currentLoc = pieceList.get(playerTurn).getLoc();
		if( (nextLoc<=255 && nextLoc>=0) && 
			!(nextLoc%16==0 && direction=="right") && 
			!(nextLoc%16==15 && direction=="left") && (bid > 0) &&
			!(nextLoc== (pieceList.get((playerTurn+1)%4).getLoc()) ||
			nextLoc == (pieceList.get((playerTurn+2)%4).getLoc()) ||
			nextLoc == (pieceList.get((playerTurn+3)%4).getLoc())
			) &&
                        // (currentLoc + 1 <=255 && currentLoc + 1>=0) && (currentLoc + 16 <=255 && currentLoc + 16>=0) && (currentLoc - 1 <=255 && currentLoc - 1>=0) && (currentLoc - 16 <=255 && currentLoc - 16>=0) &&
			!( direction.equals("up") && 
				( prevIcon[playerTurn].toString().equals( "Images/TWall.PNG" ) ||
				prevIcon[playerTurn].toString().equals( "Images/YellowBallWithTWall.PNG" ) ||
				prevIcon[playerTurn].toString().equals( "Images/BlueStarTWall.PNG" ) ||
				buttonList.get(pieceList.get(playerTurn).getLoc()+moveUnits).getIcon().toString().equals( "Images/BWall.PNG") ) 
				) &&
			
			!( direction.equals("down") && 
				( prevIcon[playerTurn].toString().equals("Images/BWall.PNG") ||
				buttonList.get(pieceList.get(playerTurn).getLoc()+moveUnits).getIcon().toString().equals("Images/TWall.PNG")  ||
				buttonList.get(pieceList.get(playerTurn).getLoc()+moveUnits).getIcon().toString().equals("Images/YellowBallWithTWall.PNG")  ||
				buttonList.get(pieceList.get(playerTurn).getLoc()+moveUnits).getIcon().toString().equals("Images/BlueStarTWall.PNG") )
				) &&
			!( direction.equals("left") &&
				( prevIcon[playerTurn].toString().equals("Images/LWall.PNG")  ||
				prevIcon[playerTurn].toString().equals("Images/BluePLanetWithLWall.PNG") ||
				prevIcon[playerTurn].toString().equals("Images/GreenBallLWall.PNG") ||
				buttonList.get(pieceList.get(playerTurn).getLoc()+moveUnits).getIcon().toString().equals("Images/RWall.PNG") ||
				buttonList.get(pieceList.get(playerTurn).getLoc()+moveUnits).getIcon().toString().equals("Images/VortexRightWall.PNG") )
				) &&
			!( direction.equals("right") &&
				( prevIcon[playerTurn].toString().equals("Images/RWall.PNG")  ||
				prevIcon[playerTurn].toString().equals("Images/VortexRightWall.PNG") ||
				buttonList.get(pieceList.get(playerTurn).getLoc()+moveUnits).getIcon().toString().equals("Images/GreenBallLWall.PNG") ||
				buttonList.get(pieceList.get(playerTurn).getLoc()+moveUnits).getIcon().toString().equals("Images/BluePLanetWithLWall.PNG") ||
				buttonList.get(pieceList.get(playerTurn).getLoc()+moveUnits).getIcon().toString().equals("Images/LWall.PNG") )
			)
			){
			buttonList.get(pieceList.get(playerTurn).getLoc()).setIcon(prevIcon[playerTurn]); 
                        
			pieceList.get(playerTurn).move(moveUnits); //next location determined
			prevIcon[playerTurn] = (ImageIcon)buttonList.get(pieceList.get(playerTurn).getLoc()).getIcon(); //Piece overriding this icon
			buttonList = save;
			buttonList.get(pieceList.get(playerTurn).getLoc()).setIcon(meepleList.get(playerTurn));

                        
			moveRobot(direction);
                        
		 
		
			 }
			 else{
							//System.out.println(bid);
							i = i + 1;
							if( prevIcon[playerTurn].toString().equals("Images/"+currChip) ) {
								turn.setText("Player "+playerTurn+" Wins");
								System.out.println("Player "+playerTurn+" Wins");
							};
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
	
	private void resetBoard() {
        buttonList = save;
        
    }
    
	
	
	public static void simple() {
		buttonList.get(251).setIcon(new ImageIcon("Images/RWall.PNG"));
		buttonList.get(246).setIcon(new ImageIcon("Images/RWall.PNG"));
		
		buttonList.get(227).setIcon(new ImageIcon("Images/YellowTriangle.PNG"));
		buttonList.get(226).setIcon(new ImageIcon("Images/RWall.PNG"));
		
		buttonList.get(218).setIcon(new ImageIcon("Images/BlueStarTWall.PNG"));
		buttonList.get(217).setIcon(new ImageIcon("Images/RWall.PNG"));
		buttonList.get(214).setIcon(new ImageIcon("Images/LWall.PNG"));
		buttonList.get(213).setIcon(new ImageIcon("Images/RedStar.PNG"));
		buttonList.get(211).setIcon(new ImageIcon("Images/BWall.PNG"));
		
		buttonList.get(205).setIcon(new ImageIcon("Images/TWall.PNG"));
		//buttonList.get(202).setIcon(new ImageIcon("Images/BWall.PNG"));
		buttonList.get(197).setIcon(new ImageIcon("Images/BWall.PNG"));
		
		buttonList.get(189).setIcon(new ImageIcon("Images/GreenBallLWall.PNG"));
		//buttonList.get(188).setIcon(new ImageIcon("Images/RWall.PNG"));
		buttonList.get(180).setIcon(new ImageIcon("Images/TWall.PNG"));
		buttonList.get(176).setIcon(new ImageIcon("Images/BWall.PNG"));
		
		buttonList.get(175).setIcon(new ImageIcon("Images/BWall.PNG"));
		buttonList.get(174).setIcon(new ImageIcon("Images/TWall.PNG"));
		buttonList.get(169).setIcon(new ImageIcon("Images/LWall.PNG"));
		buttonList.get(168).setIcon(new ImageIcon("Images/RedTriangle.PNG"));
		buttonList.get(164).setIcon(new ImageIcon("Images/GreenPlanet.PNG"));
		buttonList.get(163).setIcon(new ImageIcon("Images/RWall.PNG"));
		buttonList.get(161).setIcon(new ImageIcon("Images/TWall.PNG"));
		
		buttonList.get(159).setIcon(new ImageIcon("Images/LWall.PNG"));
		buttonList.get(158).setIcon(new ImageIcon("Images/YellowPlanet.PNG"));
		buttonList.get(152).setIcon(new ImageIcon("Images/BWall.PNG"));
		buttonList.get(146).setIcon(new ImageIcon("Images/LWall.PNG"));
		buttonList.get(145).setIcon(new ImageIcon("Images/BlueBall.PNG"));

		buttonList.get(136).setIcon(new ImageIcon("Images/BRCentre.PNG"));
		buttonList.get(135).setIcon(new ImageIcon("Images/BLCentre.PNG"));
		//buttonList.get(134).setIcon(new ImageIcon("Images/LWall.PNG"));
		buttonList.get(133).setIcon(new ImageIcon("Images/VortexRightWall.PNG"));


		buttonList.get(120).setIcon(new ImageIcon("Images/TLCentre.PNG"));
		buttonList.get(119).setIcon(new ImageIcon("Images/TRCentre.PNG"));
		buttonList.get(117).setIcon(new ImageIcon("Images/BWall.PNG"));
		buttonList.get(115).setIcon(new ImageIcon("Images/TWall.PNG"));

		buttonList.get(108).setIcon(new ImageIcon("Images/LWall.PNG"));
		buttonList.get(107).setIcon(new ImageIcon("Images/YellowBallWithTWall.PNG"));		
		buttonList.get(99).setIcon(new ImageIcon("Images/BluePLanetWithLWall.PNG"));
		//buttonList.get(98).setIcon(new ImageIcon("Images/RWall.PNG"));

		buttonList.get(94).setIcon(new ImageIcon("Images/RedStar.PNG"));
		buttonList.get(93).setIcon(new ImageIcon("Images/RWall.PNG"));
		//buttonList.get(91).setIcon(new ImageIcon("Images/BWall.PNG"));
		buttonList.get(80).setIcon(new ImageIcon("Images/BWall.PNG"));
		
		buttonList.get(70).setIcon(new ImageIcon("Images/TWall.PNG"));

		buttonList.get(63).setIcon(new ImageIcon("Images/BWall.PNG"));
		buttonList.get(57).setIcon(new ImageIcon("Images/TWall.PNG"));
		buttonList.get(55).setIcon(new ImageIcon("Images/LWall.PNG"));
		buttonList.get(54).setIcon(new ImageIcon("Images/YellowStar.PNG"));
		
		buttonList.get(42).setIcon(new ImageIcon("Images/LWall.PNG"));
		buttonList.get(41).setIcon(new ImageIcon("Images/BlueTriangle.PNG"));
		buttonList.get(34).setIcon(new ImageIcon("Images/LWall.PNG"));
		buttonList.get(33).setIcon(new ImageIcon("Images/GreenTriangle.PNG"));
		
		buttonList.get(29).setIcon(new ImageIcon("Images/RedPlanet.PNG"));
		buttonList.get(28).setIcon(new ImageIcon("Images/RWall.PNG"));
		buttonList.get(20).setIcon(new ImageIcon("Images/RedBall.PNG"));
		buttonList.get(19).setIcon(new ImageIcon("Images/RWall.PNG"));
		buttonList.get(17).setIcon(new ImageIcon("Images/BWall.PNG"));

		buttonList.get(13).setIcon(new ImageIcon("Images/BWall.PNG"));
		buttonList.get(11).setIcon(new ImageIcon("Images/RWall.PNG"));
		buttonList.get(4).setIcon(new ImageIcon("Images/BWall.PNG"));
		buttonList.get(1).setIcon(new ImageIcon("Images/RWall.PNG"));


		green = new Piece(93,1);
		red = new Piece(179,2);
		yellow = new Piece(58,3);
		blue = new Piece(0,4);

		pieceList.add(green);
		pieceList.add(red);
		pieceList.add(yellow);
		pieceList.add(blue);


		for(int i = 0; i<4;i++)	buttonList.get(pieceList.get(i).getLoc()).setIcon(meepleList.get(i)); //set robots' initial position

	}
    //Here is the proto-code for making the map for the complex/simple board
    //I cannot see the icons for whatever reason but here is most of the code
    public static void complex() {
		buttonList.get(5).setIcon(new ImageIcon("Images/RWall.PNG"));
    	buttonList.get(8).setIcon(new ImageIcon("Images/RWall.PNG"));
    	buttonList.get(10).setIcon(new ImageIcon("Images/BWall.PNG"));
    	buttonList.get(20).setIcon(new ImageIcon("Images/GreenBar.PNG"));
    	buttonList.get(25).setIcon(new ImageIcon("Images/RWall.PNG"));
    	buttonList.get(26).setIcon(new ImageIcon("Images/RedPlanet.PNG"));
    	buttonList.get(33).setIcon(new ImageIcon("Images/BWall.PNG"));
    	buttonList.get(46).setIcon(new ImageIcon("Images/BlueBar.PNG"));
    	buttonList.get(47).setIcon(new ImageIcon("Images/BWall.PNG"));
    	buttonList.get(48).setIcon(new ImageIcon("Images/RWall.PNG"));
    	buttonList.get(49).setIcon(new ImageIcon("Images/RedBall.PNG"));
    	buttonList.get(70).setIcon(new ImageIcon("Images/YellowStar.PNG"));
    	buttonList.get(71).setIcon(new ImageIcon("Images/LWall.PNG"));
    	buttonList.get(73).setIcon(new ImageIcon("Images/BlueTriangle.PNG"));
    	buttonList.get(74).setIcon(new ImageIcon("Images/LWall.PNG"));
    	buttonList.get(80).setIcon(new ImageIcon("Images/BWall.PNG"));
    	buttonList.get(82).setIcon(new ImageIcon("Images/BWall.PNG"));
    	buttonList.get(87).setIcon(new ImageIcon("Images/TWall.PNG"));
    	buttonList.get(89).setIcon(new ImageIcon("Images/TWall.PNG"));
    	buttonList.get(92).setIcon(new ImageIcon("Images/RWall.PNG"));
    	buttonList.get(93).setIcon(new ImageIcon("Images/GreenStar.PNG"));
    	buttonList.get(98).setIcon(new ImageIcon("Images/GreenTriangle.PNG"));
    	buttonList.get(99).setIcon(new ImageIcon("Images/BluePLanetWithLWall.PNG"));
    	buttonList.get(109).setIcon(new ImageIcon("Images/YellowBallWithTWall.PNG"));
    	buttonList.get(110).setIcon(new ImageIcon("Images/LWall.PNG"));
    	buttonList.get(115).setIcon(new ImageIcon("Images/TWall.PNG"));	
    	buttonList.get(117).setIcon(new ImageIcon("Images/YellowBar.PNG"));
    	buttonList.get(119).setIcon(new ImageIcon("Images/TLCentre.PNG"));
    	buttonList.get(120).setIcon(new ImageIcon("Images/TRCentre.PNG"));
    	buttonList.get(123).setIcon(new ImageIcon("Images/RedBar.PNG"));
    	buttonList.get(135).setIcon(new ImageIcon("Images/BLCentre.PNG"));
    	buttonList.get(136).setIcon(new ImageIcon("Images/BRCentre.PNG"));
    	buttonList.get(145).setIcon(new ImageIcon("Images/LWall.PNG"));
    	buttonList.get(146).setIcon(new ImageIcon("Images/YellowTriangle.PNG"));
    	buttonList.get(151).setIcon(new ImageIcon("Images/BWall.PNG"));
    	buttonList.get(154).setIcon(new ImageIcon("Images/YellowPlanet.PNG"));
    	buttonList.get(155).setIcon(new ImageIcon("Images/LWall.PNG"));
    	buttonList.get(160).setIcon(new ImageIcon("Images/BWall.PNG"));
    	buttonList.get(162).setIcon(new ImageIcon("Images/TWall.PNG"));
    	buttonList.get(167).setIcon(new ImageIcon("Images/VortexRightWall.PNG"));
    	buttonList.get(170).setIcon(new ImageIcon("Images/TWall.PNG"));
    	buttonList.get(172).setIcon(new ImageIcon("Images/BWall.PNG"));
    	buttonList.get(188).setIcon(new ImageIcon("Images/RedTriangle.PNG"));
    	buttonList.get(189).setIcon(new ImageIcon("Images/GreenBallLWall.PNG"));
    	buttonList.get(195).setIcon(new ImageIcon("Images/GreenPlanet.PNG"));
    	buttonList.get(196).setIcon(new ImageIcon("Images/LWall.PNG"));
    	buttonList.get(199).setIcon(new ImageIcon("Images/GreenBar.PNG"));
    	buttonList.get(202).setIcon(new ImageIcon("Images/YellowBar.PNG"));
    	buttonList.get(206).setIcon(new ImageIcon("Images/TWall.PNG"));
    	buttonList.get(208).setIcon(new ImageIcon("Images/BWall.PNG"));
    	buttonList.get(210).setIcon(new ImageIcon("Images/RedBar.PNG"));
    	buttonList.get(211).setIcon(new ImageIcon("Images/RWall.PNG"));
    	buttonList.get(212).setIcon(new ImageIcon("Images/BlueBall.PNG"));
    	buttonList.get(214).setIcon(new ImageIcon("Images/BWall.PNG"));
    	buttonList.get(217).setIcon(new ImageIcon("Images/RWall.PNG"));
    	buttonList.get(218).setIcon(new ImageIcon("Images/BlueStarTWall.PNG"));
    	buttonList.get(230).setIcon(new ImageIcon("Images/RedStar.PNG"));
    	buttonList.get(231).setIcon(new ImageIcon("Images/LWall.PNG"));
    	buttonList.get(236).setIcon(new ImageIcon("Images/BlueBar.PNG"));
    	buttonList.get(247).setIcon(new ImageIcon("Images/RWall.PNG"));
    	buttonList.get(251).setIcon(new ImageIcon("Images/RWall.PNG"));
		
		green = new Piece(56,1);
		red = new Piece(81,2);
		yellow = new Piece(180,3);
		blue = new Piece(200,4);

		pieceList.add(green);
		pieceList.add(red);
		pieceList.add(yellow);
		pieceList.add(blue);

		for(int i = 0; i<4;i++) buttonList.get(pieceList.get(i).getLoc()).setIcon(meepleList.get(i)); //set robots' initial position    	
    	
    }
    

    

	public static void main ( String [] args){
		//Size choosing
				JFrame intro = new JFrame("Choose game mode");
				JPanel icky = new JPanel();
				JButton simple = new JButton("Simple");
				JButton complex = new JButton("Complex");
				
				simple.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent arg0) {
						new RicochetRobots();
						simple();
						save = buttonList;
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
