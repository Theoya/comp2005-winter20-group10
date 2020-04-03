
public class Player {
	private int bid=100;
	private int point=0;
	private static String playerName;
	public Player(String name) {
		Player.setPlayerName(name);
		
	}
	public int getBid () {
		return bid;
	}
	public int getPoint() {
		return point;
	}
	public void setBid (int b) {
		this.bid = b;
	}
	public void setPoint(int p) {
		this.point = p;
	}
	public static String getPlayerName() {
		return playerName;
	}
	public static void setPlayerName(String playerName) {
		Player.playerName = playerName;
	}
	

}
