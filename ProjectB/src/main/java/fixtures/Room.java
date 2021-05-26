package fixtures;


public class Room extends Fixture {

		private Room[] exits;


		public Room(String name, String shortDesc, String longDesc) {
			super(name, shortDesc, longDesc);

			this.exits = new Room[4];
		}

		public Room[] getExits() {
			return this.exits;
		}
		
		public void setExits(Room[] exits) {
			this.exits = exits;
		}


		public Room getExitByDirection(String direction) {
			int index = -1;
			switch (direction.toLowerCase().intern()) {
			case "north":
				index = 0;
				break;
			case "south":
				index = 1;
				break;
			case "east":
				index = 2;
				break;
			case "west":
				index = 3;
				break;
			}
			
			if (index == -1 || this.exits[index] == null) {
				System.out.println("There is no room in that direction, please pick another.");
				return this;
			}

			return this.exits[index];
		}
		
		public void setExitByIndex(Room exit, int index) {
			this.exits[index] = exit;
		}
		
	}
