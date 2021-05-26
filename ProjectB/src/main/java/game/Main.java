package game;
//a tour of a cottage, there are 4 rooms
import java.util.Scanner;

import fixtures.Room;

public class Main {

	private static RoomManager manager = new RoomManager(4);

	private static Player player = new Player();

	private static boolean running;

	public static void main(String[] args) {

		manager.init();
		running = true;

		System.out.println("Welcome to the Cottage! Feel free to have a look around."
				+ "\nYou can move by typing the word \"go\" or \"move\","
				+ " followed by typing one of 4 directions,"
				+ "\n\"north\", \"south\", \"east\" or \"west\". "
				+ "When you are done looking around you can type"
				+ " \"quit\" or \"exit\" to close the program.");

		player.setCurrentRoom(manager.getStartingRoom());

		while (running) {
			printRoom();
			String[] input = collectInput();
			parse(input);
		}
		

		System.out.println("Thanks for Visiting!");
	}
	
	private static void printRoom() {
		System.out.println(":::: CURRENT ROOM ::::");
		System.out.println(player.getCurrentRoom());
	}
	

	private static String[] collectInput() {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		String[] phrase = input.split(" ");
		return phrase;		

	}
	
	private static void parse(String[] input) {

		String command = input[0].toLowerCase().intern();
		String direction = "";
		if (input.length > 1) {
			direction = input[1].toLowerCase().intern();
		}
		
		if (command == "go" || command == "move") {
			System.out.println("Moving: " + direction);
			Room move = player.getCurrentRoom().getExitByDirection(direction);
			player.setCurrentRoom(move);
		} else if (command == "quit" || command == "exit") {
			running = false;
		}
	}
}
