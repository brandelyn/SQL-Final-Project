package videoGame;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import videoGame.dao.PlayerDao;
import videoGame.entity.Player;

public class VideoGameApplication {

	private Scanner scanner = new Scanner(System.in);
	private PlayerDao playerDao = new PlayerDao();

	public static void main(String[] args) {
		new VideoGameApplication().run();
	}

	private void run() {
		while (true) {
			printInstructions();
			
			System.out.println("Enter a selection: ");
			String choice = scanner.nextLine();
			
			if(choice.isBlank()) {
				break;
			}
			try {
			switch(choice) {
			case "1":
				createPlayer();
				break;
				
			case "2":
				modifyPlayer();
				break;
				
			case "3":
				listPlayers();
				break;
			
			case "4":
				deletePlayer();
				break;
				
				default:
					System.out.println("Invalid selection, try again.");
			}
		}
			catch(Exception e) {
			System.out.println("You got an error!: " + e.getMessage());
			break;
			}
		}
	}

	private void deletePlayer() throws SQLException {
		listPlayers();
		System.out.println("Enter the Player ID to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		
		playerDao.deletePlayer(id);
		listPlayers();
	}

	private void modifyPlayer() throws SQLException {
		listPlayers();
		System.out.println("Enter the Player ID to modify:");
		int id = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Enter the new Player name: ");
		String playerName = scanner.nextLine();
		
		playerDao.modifyPlayer(id, playerName);
		listPlayers();
	}

	private void listPlayers() throws SQLException {
		List<Player> players = playerDao.fetchPlayers();
		players.stream().forEach(player -> System.out.println(player));
	}

	private void createPlayer() throws SQLException {
		System.out.print("Enter a Player name: ");
		String playerName = scanner.nextLine();
		playerDao.createPlayer(playerName);
		
	}

	private void printInstructions() {
		System.out.println(" Select an option:\n -------------------------------- ");
		System.out.println("1: Create a player.");
		System.out.println("2: Modify a player.");
		System.out.println("3: List all players.");
		System.out.println("4: Delete a player.");
		
	}
}
