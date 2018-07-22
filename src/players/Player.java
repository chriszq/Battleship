package players;

import board.Board;

public interface Player {

  void placeFleetOnBoard();

  void fireAt(Board board);
}
