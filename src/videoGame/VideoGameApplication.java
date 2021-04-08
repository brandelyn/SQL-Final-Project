package videoGame;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import videoGame.dao.AbilityDao;
import videoGame.dao.PlayerDao;
import videoGame.dao.WeaponDao;
import videoGame.entity.Player;

public class VideoGameApplication {

	private Scanner scanner = new Scanner(System.in);
	private PlayerDao playerDao = new PlayerDao();
	private AbilityDao abilityDao = new AbilityDao();
	private WeaponDao weaponDao = new WeaponDao();

	public static void main(String[] args) {
		new VideoGameApplication().run();
	}

	private void run() {
		while (true) {
			printInstructions();

			System.out.println("Enter a selection: ");
			String choice = scanner.nextLine();

			if (choice.isBlank()) {
				break;
			}
			try {
				switch (choice) {
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
			} catch (Exception e) {
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

		printModifyInstructions();

		System.out.println("Enter a selection: ");
		String choice = scanner.nextLine();

		try {
			switch (choice) {
			case "1":
				modifyPlayerName(id);
				break;

			case "2":
				modifyAbility(id);
				break;

			case "3":
				modifyWeapon(id);
				break;

			default:
				System.out.println("Invalid selection, try again.");
			}
		} catch (Exception e) {
			System.out.println("You got an error!: " + e.getMessage());

		}
		listPlayers();
	}

	private void listPlayers() throws SQLException {
		List<Player> players = playerDao.fetchPlayers();
		players.stream().forEach(player -> System.out.println(player));
	}

	private void createPlayer() throws SQLException {
		System.out.print("Enter a Player name: ");
		String playerName = scanner.nextLine();
		int playerId = playerDao.createPlayer(playerName);
		System.out.print("Enter an Ability: ");
		String ability = scanner.nextLine();
		abilityDao.createAbility(ability, playerId);
		System.out.print("Enter a weapon: ");
		String weapon = scanner.nextLine();
		weaponDao.createWeapon(weapon, playerId);

	}

	private void printInstructions() {
		System.out.println(" Select an option:\n -------------------------------- ");
		System.out.println("1: Create a player.");
		System.out.println("2: Modify a player.");
		System.out.println("3: List all players.");
		System.out.println("4: Delete a player.");

	}

	private void printModifyInstructions() {
		System.out.println(" Select an option:\n -------------------------------- ");
		System.out.println("1: Modify Player Name.");
		System.out.println("2: Modify Ability");
		System.out.println("3: Modify Weapon.");
	}

	private void modifyPlayerName(int id) throws SQLException {
		System.out.print("Enter a new player name: ");
		String playerName = scanner.nextLine();
		playerDao.modifyPlayer(id, playerName);
	}

	private void modifyAbility(int id) throws SQLException {
		System.out.print("Enter a new ability: ");
		String ability = scanner.nextLine();
		abilityDao.modifyAbility(id, ability);

	}

	private void modifyWeapon(int id) throws SQLException {
		System.out.print("Enter a new weapon: ");
		String weapon = scanner.nextLine();
		weaponDao.modifyWeapon(id, weapon);
	}
}
