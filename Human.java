import java.util.Scanner;

public class Human implements Player {

  private Board board;

  public Human() {
    this.board = new Board();
  }

  @Override
  public void placeFleetOnBoard() {
    Orientation orientation = Orientation.HORIZONTAL;
    int row = 0;
    int col = 0;
    String temp = " ";

    Scanner kb = new Scanner(System.in);

    for (Ship x : board.getFleet()) {
      System.out.printf("Orientation of %s (h/v): ", x.getShipType().getName());
      while (!kb.hasNext("[hv]{1}")) {
      System.out.printf("Invalid input. Must be \"h\" or \"v\".");
      System.out.printf("\nOrientation of %s (h/v): ", x.getShipType().getName());
      kb.next();
      }
      temp = kb.next();
      switch (temp) {
        case "h":
          orientation = Orientation.HORIZONTAL;
          break;
        case "v":
          orientation = Orientation.VERTICAL;
          break;
      }
      x.setOrientation(orientation);

      System.out.printf("%s bow row number: ", x.getShipType().getName());
      while (!kb.hasNext("[0-9]{1}")) {
        System.out.printf("Invalid row number. Must be integer in the range [0,9].");
        System.out.printf("\n%s bow row number: ", x.getShipType().getName());
        kb.next();
      }
      row = kb.nextInt();

      System.out.printf("%s bow column number: ", x.getShipType().getName());
      while (!kb.hasNext("[0-9]{1}")) {
        System.out.printf("Invalid column number. Must be integer in the range [0,9].");
        System.out.printf("\n%s bow column number: ", x.getShipType().getName());
        kb.next();
      }
      col = kb.nextInt();

      if (!board.isShipOverlap(row, col, x) && !board.isShipOutOfBounds(row, col, x)) {
        board.putShipAt(row, col, x);
      }

    }
  }

  @Override
  public void fireAt(Board board) {

  }

  public Board getBoard() {
    return this.board;
  }
}
