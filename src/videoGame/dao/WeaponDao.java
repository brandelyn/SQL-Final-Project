package videoGame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WeaponDao {
	
	public void createWeapon(String weapon, int playerId) throws SQLException {
		String sql = "INSERT INTO weapons (weapon, player_id) VALUES (?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DBConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, weapon);
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
