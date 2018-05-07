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

	public boolean isShipOverlap(int row, int col, boolean horizontal, Water[][] arr) {
		for (int i = 0; i < shipParts.length; i ++) {
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
		for (int i = 0; i < shipParts.length; i ++) {
			if (horizontal) {
				shipParts[i].putShipPartAt(row, col + i, arr);
			} else {
					shipParts[i].putShipPartAt(row + i, col, arr);
			}
		}
	}

}
