package videoGame.entity;

public class Player {
	
	private int playerId;
    private String playerName;

	public Player(int playerId, String playerName) {
    	this.playerId = playerId;
    	this.playerName = playerName;
    }

	public String getPlayerName() {
		return playerName;
	}

	public int getPlayerId() {
		return playerId;
	}
	
    @Override
	public String toString() {
		return "Player [playerId = " + playerId + ", playerName = " + playerName + "]";
	}
}
