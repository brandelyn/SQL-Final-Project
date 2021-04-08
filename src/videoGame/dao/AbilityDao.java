package videoGame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AbilityDao {
	
	public void createAbility(String ability, int playerId) throws SQLException {
		String sql = "INSERT INTO abilities (ability, player_id) VALUES (?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DBConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, ability);
			statement.setInt(2, playerId);
			
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
	public void modifyAbility(int playerId, String ability) throws SQLException {
		String sql = "UPDATE abilities SET ability = ? WHERE player_id = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DBConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, ability);
			statement.setInt(2, playerId);
			
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
