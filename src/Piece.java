
public class Piece {
	
	private int location;
	private int player;

	public Piece(int loc, int play) {
		this.location = loc;
		this.player = play;
	}
	void move(int i) {
		
		this.location = location+i;
		
	}
	public int getLoc() {
		return(location);
	}
	
	
}
