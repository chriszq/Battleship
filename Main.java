import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

  //testing some methods

    Board board3 = new Board();
    for (Ship x : board3.getFleet()) {
      System.out.println(x.getShipType());
    }

    board3.getFleet()[0].putShipAtRandom(board3.getOcean());
    board3.getFleet()[1].putShipAtRandom(board3.getOcean());
    board3.getFleet()[2].putShipAtRandom(board3.getOcean());
    board3.getFleet()[3].putShipAtRandom(board3.getOcean());
    board3.getFleet()[4].putShipAtRandom(board3.getOcean());

    Scanner kb = new Scanner(System.in);
    int row;
    int col;


    while(!board3.isFleetSunk()) {
    System.out.print("target row: ");
    row = Integer.parseInt(kb.nextLine());
    System.out.print("target col: ");
    col = Integer.parseInt(kb.nextLine());

    board3.getOcean()[row][col].fireAt();
    board3.printOcean();
    }
  }  

}
