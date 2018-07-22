package players;

import board.Board;
import shipcomponents.Grid;
import shipcomponents.HitStatus;
import shipcomponents.ShipPart;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class HuntTargetBot extends Computer {

  private Stack<Grid> targets;
  private Board board;

  public HuntTargetBot() {
    this.targets = new Stack<Grid>();
  }

  @Override
  public void fireAt(Board board) {
    System.out.println("stack: " + targets);
    if (targets.empty()) {
      System.out.println("randoming target...");
      Grid grid = randomTarget(board);
      grid.setHitStatus(HitStatus.HIT);

      if (grid.getClass() == ShipPart.class) {
        addTargetsAroundGrid(board, grid);
      }
    } else {
      System.out.println("popping target from stack...");
      Grid grid = targets.pop();
      grid.setHitStatus(HitStatus.HIT);

      if (grid.getClass() == ShipPart.class) {
        addTargetsAroundGrid(board, grid);
      }
    }
  }

  public void addTargetsAroundGrid(Board board, Grid grid) {
    List<Point> points = nsewPointsAroundPoint(grid.getPoint());
    Grid[][] ocean = board.getOcean();

    for (Point p : points) {
      int row = (int)p.getY();
      int col = (int)p.getX();

      if (!Board.isCoordOutOfBounds(row) 
        && !Board.isCoordOutOfBounds(col)
        && targets.search(ocean[row][col]) == -1
        && ocean[row][col].getHitStatus() == HitStatus.UNHIT) {
        targets.push(ocean[row][col]);
      }
    }
  }

  public List<Point> nsewPointsAroundPoint(Point point) {
    int x = (int)point.getX();
    int y = (int)point.getY();

    List<Point> points = new ArrayList<Point>();

    points.add(new Point(x, y + 1));
    points.add(new Point(x, y - 1));
    points.add(new Point(x + 1, y));
    points.add(new Point(x - 1, y));

    return points;
  }
 
}
