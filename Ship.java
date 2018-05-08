public class Ship {

	private ShipType shipType;
  private ShipPart[] shipParts;
	private boolean horizontal;

	//public Ship() {}
		
	public Ship(ShipType shipType) {
		this.shipType = shipType;
		this.shipParts = new ShipPart[shipType.getShipLength()];
		
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

	public boolean isShipSunk() {
		for (ShipPart x : shipParts) {
			if (!x.getHitStatus()) {
				return false;
			}
		} 
		return true;
	}
}
