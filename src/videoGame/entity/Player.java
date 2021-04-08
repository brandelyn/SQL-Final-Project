package videoGame.entity;

public class Player {
	
	private int playerId;
    private String playerName;
    private String weapon;
    private String ability;

	public Player(int playerId, String playerName, String weapon, String ability) {
    	this.playerId = playerId;
    	this.playerName = playerName;
    	this.weapon = weapon;
    	this.ability = ability;
    }

	public String getPlayerName() {
		return playerName;
	}

	public int getPlayerId() {
		return playerId;
	}
	
	
	
    @Override
	public String toString() {
		return "Player [playerId = " + playerId + ", playerName = " + playerName + ", ability = " + ability + ", weapon = " + weapon + "]";
	}

	public String getWeapon() {
		return weapon;
	}

	public String getAbility() {
		return ability;
	}

}
