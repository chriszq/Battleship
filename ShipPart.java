public class ShipPart extends Water {

	public ShipPart() {
		this.hitStatus = false;
	}

	@Override
	public String toString() {
		return (hitStatus) ? "@" : "-";
	}

  @Override
	public void fireAt() {
		if (!this.getHitStatus()) {
			this.setHitStatus(true);
			System.out.println("you hit the enemy");
		} else {
			System.out.println("you already fired at this spot");
		}
	}

	public boolean isShipPartOverlap(int row, int col, Water[][] arr) {
		return (arr[row][col].getClass() == ShipPart.class) ? true : false;
	}

	public void putShipPartAt(int row, int col, Water[][] arr) {
		arr[row][col] = this;
	}
}
