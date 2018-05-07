public class Board {

	private static final int OCEAN_DIM = 10;

	private Water[][] ocean;
	private Ship[] fleet;
	private int shotCount;
	private int hitCount;
	private int shipsSunkCount;

	public Board() {
		this.ocean = new Water[OCEAN_DIM][OCEAN_DIM];
		
		for (int i = 0; i < OCEAN_DIM; i++) {
			for (int j = 0; j < OCEAN_DIM; j++) {
				this.ocean[i][j] = new Water();
			}
		}

		//hard code number of ships and one Ship type for testing purposes
		this.fleet = new Ship[5];

		for (int i = 0; i < this.fleet.length; i++) {
			this.fleet[i] = new Ship();
		}
	}
  
	public Water[][] getOcean() {
		return this.ocean;
	}

	public Ship[] getFleet() {
		return this.fleet;
	}

	public void printOcean() {
		for (int i = 0; i < OCEAN_DIM; i++) {
			System.out.println();
			for (int j = 0; j < OCEAN_DIM; j++) {
				System.out.printf("%s ", ocean[i][j]);
			}
		}
		System.out.println();
	}

	public boolean isFleetSunk() {
		for (Ship x : fleet) {
			if (!x.isShipSunk()) {
				return false;
			}
		} 
		return true;
	}

}
