public class Ship {
  
  private ShipPart[] shipParts;
	private boolean horizontal;
  //private int lives;

	public Ship() {
		//all ships length 3 for now
		shipParts = new ShipPart[3];
		
		for (int i = 0; i < shipParts.length; i ++) {
			shipParts[i] = new ShipPart();
		}

		horizontal = false;
	}

	//method not used anywhere yet
	public ShipPart[] getShipParts() {
		return this.shipParts;
	}

	//assume all Ships mus) be placed horizontally for now
	public boolean isShipOverlap(int row, int col, Water[][] arr) {
		for (int i = 0; i < shipParts.length; i ++) {
			if (shipParts[i].isShipPartOverlap(row, col + i, arr)) {
				return true;
			}
		}
			return false;
	}

	public void putShipAt(int row, int col, Water[][] arr) {
		for (int i = 0; i < shipParts.length; i ++) {
			shipParts[i].putShipPartAt(row, col + i, arr);
		}
	}

}
