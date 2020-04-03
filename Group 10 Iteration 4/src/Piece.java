import java.util.*;
public class Piece {
	
	private int location;
	private int player;
	private int bid;
	private int lowestBid = 100;
	private int timeLog;
	public Piece(int loc, int play) {
		this.location = loc;
		this.player = play;
		
	}
	public void move(int i) {
		
		this.location = location+i;
		
	}
	public int getLoc() {
		return(location);
	}

	public void setLoc(int loc){
		this.location = loc;
	}
	
	public int getPlayer() {
		return(player);
	}
	public int getBid() {
		
		return(this.bid);
	}
	public void makeBid(int scale, int timeLog) {
		Random rand = new Random();
		
		this.bid = rand.nextInt(scale+1);
		if (scale<=lowestBid) {
			if (bid <= lowestBid) {this.bid = rand.nextInt(scale+1);}
			}
		else {
			if (bid >= lowestBid) {this.bid = rand.nextInt(lowestBid+1);}
		}
		if (bid == 0) {this.bid+=1;}
		this.lowestBid = bid;
		if (timeLog >= 2) {this.timeLog = timeLog;}
		else {this.timeLog = 0;}
	}
	public int getTimeLog() {
		return(timeLog);
	}




}
	






