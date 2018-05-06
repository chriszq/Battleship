public class Main {

  public static void main(String[] args) {

	//testing some methods
		Board test = new Board();
		test.printOcean();
		test.getOcean()[0][0].fireAt();	
		test.printOcean();

		Ship kappa = new Ship();
		kappa.putShipAt(1,1,test.getOcean());
		test.getOcean()[1][1].fireAt();
		test.getOcean()[1][2].fireAt();
		test.getOcean()[1][3].fireAt();
		test.getOcean()[1][4].fireAt();
		test.printOcean();

  }  

}
