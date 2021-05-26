package game;

import fixtures.Room;

public class RoomManager {
	// starting room
	private Room startingRoom;
	
	// all rooms in the house
	private Room[] house;
	
	public RoomManager(int houseSize) {
		house = new Room[houseSize];
	}
	

	public void init() {
		Room room1 = new Room(
				"The Entryway",
				"an entryway",
				"This is the entryway of the cottage. "
				+ "There is a wooden shoe rack in front of you and a blue rug beneath your feet. "
				+ "The living room is to the north, the bedroom is to the west, and the kitchen is to the east.");
		
		this.house[0] = room1; // add room 1 to house
		
		Room room2 = new Room(
				"The Living room",
				"a living room",
				"This is the living room of the cottage. "
				+ "In front of you is a brick fireplace with two brown couches framing it. "
				+ "Between the couches is a wooden coffee table with a vase on top of it. "
				+ "The entryway is to the south.");
		
		this.house[1] = room2; // add room 2 to house
		
		Room room3 = new Room(
				"The Kitchen",
				"a kitchen.",
				"This is the kitchen of the cottage. "
				+ "It is bright with a large window in front of the sink. "
				+ "There is a round table inside surrounded by 4 chairs. "
				+ "The entryway is to the west.");
		this.house[2] = room3; // add room 3 to house
		
		
		Room room4 = new Room(
				"The Bedroom",
				"a bedroom",
				"This is the bedroom of the cottage. "
				+ "In the middle is a bed with a floral comforter with two side tables. "
				+ "Covering the windows are light blue curtains. "
				+ "The entryway is to the east.");
		this.house[3] = room4; // add room 4 to house
		

		this.startingRoom = room1;
		
		Room[] room1Exits = {room2, null, room3, room4};
		room1.setExits(room1Exits);
		

		room2.setExitByIndex(room1, 1);
		room3.setExitByIndex(room1, 3);
		room4.setExitByIndex(room1, 2);
	}
	
	public Room getRoom(int index) {
		if (index < 0) {
			System.out.println("I did not recognize that.");
			return null;
		}
		return house[index];
	}
	
	public Room getRoom(String roomName) {
		int index = -1;
		for (int i = 0; i < house.length; i++) {
			if (roomName.toLowerCase() == house[i].getName().toLowerCase()) {
				index = i;
			}
		}
		
		return getRoom(index);
	}


	public Room getStartingRoom() {
		return startingRoom;
	}

	public void setStartingRoom(Room startingRoom) {
		this.startingRoom = startingRoom;
	}

	public Room[] getHouse() {
		return house;
	}

	public void setHouse(Room[] house) {
		this.house = house;
	}
}
