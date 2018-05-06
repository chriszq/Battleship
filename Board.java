public class Board {

	private static final int OCEAN_DIM = 10;

	private Water[][] ocean;
	private int shotCount;
	private int hitCount;
	private int shipsSunkCount;

	public Board() {
		this.ocean = new Water[OCEAN_DIM][OCEAN_DIM];
		
		for (int i = 0; i < OCEAN_DIM; i ++) {
			for (int j = 0; j < OCEAN_DIM; j ++) {
				this.ocean[i][j] = new Water();
			}
		}
	}
  
	public Water[][] getOcean() {
		return this.ocean;
	}

	public void printOcean() {
		for (int i = 0; i < OCEAN_DIM; i ++) {
			System.out.println();
			for (int j = 0; j < OCEAN_DIM; j ++) {
				System.out.printf("%s ", this.ocean[i][j]);
			}
		}
		System.out.println();
	}

}
