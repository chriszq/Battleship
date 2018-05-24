import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Board {

  public static final int OCEAN_DIM = 10;

  private Grid[][] ocean;
  private Ship[] fleet;

  public Board() {
    this.ocean = new Grid[OCEAN_DIM][OCEAN_DIM];
    for (int i = 0; i < OCEAN_DIM; i++) {
      for (int j = 0; j < OCEAN_DIM; j++) {
        this.ocean[i][j] = new Water();
      }
    }

    this.fleet = new Ship[ShipType.values().length];

    int count = 0;
    for (ShipType shipType : ShipType.values()) {
      this.fleet[count] = new Ship(shipType);
      count++;
    }
  }
  
  public Grid[][] getOcean() {
    return this.ocean;
  }

  public Ship[] getFleet() {
    return this.fleet;
  }

  public void printOcean() {
    /*print column numbers*/
    System.out.print("    ");
    for (int i = 0; i < OCEAN_DIM; i++) {
      System.out.printf("%d ", i);
    }
   /*print column separator*/ 
    System.out.println("\n_______________________");
  /*print row numbers and separators*/
    for (int i = 0; i < OCEAN_DIM; i++) {
      System.out.printf("%d | ", i);
      for (int j = 0; j < OCEAN_DIM; j++) {
        System.out.printf("%s ", ocean[i][j].getIcon());
      }
      System.out.println();
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

  public boolean isShipPartOverlap(int row, int col) {
    return (ocean[row][col].getClass() == ShipPart.class) ? true : false;
  }

  public void putShipPartAt(int row, int col, ShipPart shipPart) {
    ocean[row][col] = shipPart;
    shipPart.getPoint().setLocation(col, row);
  }

  public boolean isShipOverlap(int row, int col, Ship ship) {
    switch (ship.getOrientation()) {
      case HORIZONTAL:
        for (int i = 0, n = ship.getShipParts().size(); i < n; i++) {
          if (isShipPartOverlap(row, col + i)) {
            return true;
          }
        }
        return false;
      case VERTICAL:
        for (int i = 0, n = ship.getShipParts().size(); i < n; i++) {
          if (isShipPartOverlap(row + i, col)) {
            return true;
          }
        }
        return false;
    }
    return false;
  }

  public void putShipAt(int row, int col, Ship ship) {
    switch (ship.getOrientation()) {
      case HORIZONTAL:
        for (int i = 0, n = ship.getShipParts().size(); i < n; i++) {
          putShipPartAt(row, col + i, ship.getShipParts().get(i));
        }
        break;
      case VERTICAL:
        for (int i = 0, n = ship.getShipParts().size(); i < n; i++) {
          putShipPartAt(row + i, col, ship.getShipParts().get(i));
        }
        break;
    }
  }

  public void putShipAtRandom(Ship ship) {
    Random r = new Random();
    int randRow = 0;
    int randCol = 0;

    do {
      if (r.nextInt(2) == 0) {
        ship.setOrientation(Orientation.VERTICAL);
      } else {
        ship.setOrientation(Orientation.HORIZONTAL);
      }

      switch (ship.getOrientation()) {
        case HORIZONTAL:
          randRow = r.nextInt(OCEAN_DIM);
          randCol = r.nextInt(OCEAN_DIM - ship.getShipParts().size() + 1);
          break;
        case VERTICAL:
          randRow = r.nextInt(OCEAN_DIM - ship.getShipParts().size() + 1);
          randCol = r.nextInt(OCEAN_DIM);
          break;
      }
    } while (isShipOverlap(randRow, randCol, ship));

    putShipAt(randRow, randCol, ship);

    //temporary for testing
    System.out.printf("random stuff are: %s, %s, %s\n ", randRow, randCol, ship.getOrientation());
  }

  public boolean isCoordOutOfBounds(int coord) {
    return (coord >= OCEAN_DIM || coord < 0);
  }

  public boolean isShipOutOfBounds(int row, int col, Ship ship) {
    switch (ship.getOrientation()) {
      case HORIZONTAL:
        for (int i = col, n = col + ship.getShipType().getLength(); i < n; i++) {
          if (isCoordOutOfBounds(i)) {
            return true;
           }
        }
        return (isCoordOutOfBounds(row));
      case VERTICAL:
        for (int i = row, n = row + ship.getShipType().getLength(); i < n; i++) {
          if (isCoordOutOfBounds(i)) {
            return true;
          }
        }
        return (isCoordOutOfBounds(col));
      default:
        return true;
    }
  }
}
