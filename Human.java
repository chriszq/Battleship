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

    Scanner kb = new Scanner(System.in);

    for (Ship x : board.getFleet()) {
      System.out.printf("Orientation of %s (h/v): ", x.getShipType().getName());
        String userInput = kb.nextLine();
        switch (userInput) {
          case "h":
            orientation = Orientation.HORIZONTAL;
            break;
          case "v":
            orientation = Orientation.VERTICAL;
            break;
        }

      x.setOrientation(orientation);

      System.out.printf("%s bow row number: ", x.getShipType().getName());
      row = Integer.parseInt(kb.nextLine());
      System.out.printf("%s bow column number: ", x.getShipType().getName());
      col = Integer.parseInt(kb.nextLine());

      if (!board.isShipOverlap(row, col, x) && !board.isShipOutOfBounds(x, row, col)) {
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
