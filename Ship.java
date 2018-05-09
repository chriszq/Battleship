import java.util.Random;

public class Ship {

	private ShipType shipType;
  private ShipPart[] shipParts;
	private boolean horizontal;

	public Ship(ShipType shipType) {
		this.shipType = shipType;
		this.shipParts = new ShipPart[shipType.getLength()];
		
		for (int i = 0; i < this.shipParts.length; i++) {
			this.shipParts[i] = new ShipPart();
		}

		this.horizontal = false;
	}

	public ShipType getShipType() {
		return this.shipType;
	}

	public ShipPart[] getShipParts() {
		return this.shipParts;
	}

	public boolean isShipOverlap(int row, int col, boolean horizontal, Water[][] arr) {
		for (int i = 0; i < shipParts.length; i++) {
			if (horizontal) {
				if (shipParts[i].isShipPartOverlap(row, col + i, arr)) {
				return true;
				}
			} else if (shipParts[i].isShipPartOverlap(row + i, col, arr)) {
					return true;
			}    
		}
			return false;
	}		

	public void putShipAt(int row, int col, boolean horizontal, Water[][] arr) {
		for (int i = 0; i < shipParts.length; i++) {
			if (horizontal) {
				shipParts[i].putShipPartAt(row, col + i, arr);
			} else {
					shipParts[i].putShipPartAt(row + i, col, arr);
			}
		}
	}

	public void putShipAtRandom(Water[][] arr) {
		Random r = new Random();
		int randRow;
		int randCol;
		boolean randOrientation;

		do {
			randRow = r.nextInt(10);
			randCol = r.nextInt(10);
			randOrientation = (r.nextInt(2) == 0) ? false : true;	
		} while (isShipOverlap(randRow, randCol, randOrientation, arr));

		putShipAt(randRow, randCol, randOrientation, arr);

		System.out.printf("the randomed values are: %s, %s, %s\n ", randRow, randCol, randOrientation);
	}

	public boolean isShipSunk() {
		for (ShipPart x : shipParts) {
			if (!x.getHitStatus()) {
				return false;
			}
		} 
		return true;
	}
}
