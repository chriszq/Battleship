package players;

import board.Board;
import shipcomponents.Grid;
import shipcomponents.HitStatus;
import shipcomponents.Orientation;
import shipcomponents.Ship;
import shipcomponents.ShipPart;

import java.util.Random;

public class Computer implements Player {

  private Board board;

  public Computer() {
    this.board = new Board();
  }

  @Override
  public void placeFleetOnBoard() {
    for (Ship x : board.getFleet()) {
      board.putShipAtRandom(x);
    }
  }

  @Override
  public void fireAt(Board board) {
    randomTarget(board).setHitStatus(HitStatus.HIT);
  }

  public Board getBoard() {
    return this.board;
  }

  public Grid randomTarget(Board board) {
    Random r = new Random();   
    int row = 0;
    int col = 0;

    do {
      row = r.nextInt(10);
      col = r.nextInt(10);
    } while (board.getOcean()[row][col].getHitStatus() != HitStatus.UNHIT);

    return board.getOcean()[row][col];
  } 
}
