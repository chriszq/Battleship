import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

	//testing some methods
/*
		Board test = new Board();
		test.printOcean();
		test.getOcean()[0][0].fireAt();	
		test.printOcean();

		Ship kappa = new Ship();
		kappa.putShipAt(1, 1, false, test.getOcean());
		test.getOcean()[1][1].fireAt();
		test.getOcean()[1][2].fireAt();
		test.getOcean()[1][3].fireAt();
		test.getOcean()[1][4].fireAt();
		System.out.println("kappa sunk? " + kappa.isShipSunk());
		test.printOcean();

		Ship kappa1 = new Ship();
		System.out.println(kappa.isShipOverlap(1, 0, false, test.getOcean()));
		kappa1.putShipAt(1, 0, false, test.getOcean());

		test.getOcean()[2][1].fireAt();
		test.getOcean()[3][1].fireAt();
		test.getOcean()[4][1].fireAt();
		test.getOcean()[5][1].fireAt();
		System.out.println("kappa1 sunk? " + kappa1.isShipSunk());
		test.printOcean();

		test.getOcean()[1][0].fireAt();
		test.getOcean()[2][0].fireAt();
		test.getOcean()[3][0].fireAt();
		test.getOcean()[4][0].fireAt();
		test.printOcean();
*/
/*
		Board board1 = new Board();
		//placing ships on enemy board
		board1.getFleet()[0].putShipAt(0, 0, true, board1.getOcean());
		board1.getFleet()[1].putShipAt(7, 1, false, board1.getOcean());
		board1.getFleet()[2].putShipAt(7, 6, true, board1.getOcean());
		board1.getFleet()[3].putShipAt(3, 4, true, board1.getOcean());
		board1.getFleet()[4].putShipAt(1, 9, false, board1.getOcean());

		board1.printOcean();

		Scanner kb = new Scanner(System.in);

		int row;
		int col;

		while (!board1.isFleetSunk()) {
			System.out.print("tar)et row: ");
			row = Integer.parseInt(kb.nextLine());		
			System.out.print("target col: ");
			col = Integer.parseInt(kb.nextLine());

			board1.getOcean()[row][col].fireAt();
			boa)d1.printOcean();
		}
*/
		Ship test4 = new Ship(ShipType.CARRIER);
		System.out.println(test4.isShipSunk());
		System.out.println(test4.getShipParts().length);

		Board board2 = new Board();
		for (Ship x : board2.getFleet()) {
			System.out.println(x.getShipType());
		}

		board2.getFleet()[0].putShipAt(0, 0, true, board2.getOcean());
		board2.getFleet()[1].putShipAt(6, 9, false, board2.getOcean());
		board2.getFleet()[2].putShipAt(4, 1, true, board2.getOcean());
		board2.getFleet()[3].putShipAt(7, 2, true, board2.getOcean());
		board2.getFleet()[4].putShipAt(2, 6, false, board2.getOcean());

		Scanner kb = new Scanner(System.in);
		int row;
		int col;


		while(!board2.isFleetSunk()) {
			System.out.print("target row: ");
			row = Integer.parseInt(kb.nextLine());
			System.out.print("target col: ");
			col = Integer.parseInt(kb.nextLine());

			board2.getOcean()[row][col].fireAt();
			board2.printOcean();
		}
  }  

}
