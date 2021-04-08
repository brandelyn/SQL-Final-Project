package videoGame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import videoGame.entity.Player;

public class PlayerDao {
	
	public int createPlayer(String playerName) throws SQLException {
		String sql = "INSERT INTO players (player_name) VALUES (?)";
		Connection connection = null;
		PreparedStatement statement = null;
		int playerId = 0;
		
		try {
			connection = DBConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, playerName);
			
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
			playerId = rs.getInt(1);	
			}
			}
		finally {
			if(statement != null) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
		return playerId;
	}
	
	public List<Player> fetchPlayers() throws SQLException {
		String sql = "select * from players p\r\n"
				+ "inner join abilities a on p.player_id = a.player_id \r\n"
				+ "inner join weapons w on p.player_id = w.player_id"; 
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		List<Player> players = new ArrayList<>();
		
		try {
			connection = DBConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
		    rs = statement.executeQuery();
			
		    while(rs.next()) {
		    	int playerId = rs.getInt("player_id");
		    	String playerName = rs.getString("player_name");
		    	String weapon = rs.getString("weapon");
		    	String ability = rs.getString("ability");
		    	Player player = new Player(playerId, playerName, weapon, ability);
		    	players.add(player);
		    }
			return players;
			}
		finally {
			if(rs != null) {
				rs.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
	}
	
	public void modifyPlayer(int id, String playerName) throws SQLException {
		String sql = "UPDATE players SET player_name = ? WHERE player_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DBConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, playerName);
			statement.setInt(2, id);
			
			statement.executeUpdate();
			}
		finally {
			if(statement != null) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
	}
	
	public void deletePlayer(int playerId) throws SQLException {
		String sql = "DELETE FROM players WHERE player_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DBConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, playerId);
			
			statement.executeUpdate();
			}
		finally {
			if(statement != null) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
	}
}
