package videoGame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import videoGame.entity.Player;

public class PlayerDao {
	
	public void createPlayer(String playerName) throws SQLException {
		String sql = "INSERT INTO player (player_name) VALUES (?)";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DBConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, playerName);
			
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
	
	public List<Player> fetchPlayers() throws SQLException {
		String sql = "SELECT * FROM player"; 
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
		    	Player player = new Player(playerId, playerName);
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
		String sql = "UPDATE player SET player_name = ? WHERE player_id = ?";
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
		String sql = "DELETE FROM player WHERE player_id = ?";
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
