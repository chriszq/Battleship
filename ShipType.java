public enum ShipType {
  
  CARRIER ("Carrier", 5),
  BATTLESHIP ("Battleship", 4),
  CRUISER ("Cruiser", 3),
	SUBMARINE ("Submarine", 3),
  DESTOYER ("Destroyer", 2);

	private final String shipName;
	private final int shipLength;

	private ShipType(String shipName, int shipLength) {
		this.shipName = shipName;
		this.shipLength = shipLength;
	}

	public String getShipName() {
		return this.shipName;
	}

	public int getShipLength() {
		return this.shipLength;
	}
}
