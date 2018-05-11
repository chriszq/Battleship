import java.util.Random;

public class Ship {

  private ShipType shipType;
  private ShipPart[] shipParts;
  private Orientation orientation;

  public Ship(ShipType shipType) {
    this.shipType = shipType;
    this.shipParts = new ShipPart[shipType.getLength()];

    for (int i = 0; i < this.shipParts.length; i++) {
      this.shipParts[i] = new ShipPart();
    }

    this.orientation = Orientation.HORIZONTAL;
  }

  public ShipType getShipType() {
    return this.shipType;
  }

  public ShipPart[] getShipParts() {
    return this.shipParts;
  }

  public Orientation getOrientation() {
    return this.orientation;
  }

  public boolean isShipOverlap(int row, int col, Grid[][] arr) {
    switch (orientation) {
      case HORIZONTAL:
        for (int i = 0; i < shipParts.length; i++) {
          if (shipParts[i].isShipPartOverlap(row, col + i, arr)) {
            return true;
          }
        }
        return false;
      case VERTICAL:
        for (int i = 0; i < shipParts.length; i++) {
          if (shipParts[i].isShipPartOverlap(row + i, col, arr)) {
            return true;
          }
        }
        return false;
    }
    return false;
  }

  public void putShipAt(int row, int col, Grid[][] arr) {
    switch (orientation) {
      case HORIZONTAL:
        for (int i = 0; i < shipParts.length; i++) {
          shipParts[i].putShipPartAt(row, col + i, arr);
        }
        break;
      case VERTICAL:
        for (int i = 0; i < shipParts.length; i++) {
          shipParts[i].putShipPartAt(row + i, col, arr);
        }
        break;
    }
  }

  public void putShipAtRandom(Grid[][] arr) {
    Random r = new Random();
    int randRow = 0;
    int randCol = 0;

    do {
      orientation = (r.nextInt(2) == 0) ? Orientation.VERTICAL : Orientation.HORIZONTAL;
      switch (orientation) {
        case HORIZONTAL:
          randRow = r.nextInt(Board.OCEAN_DIM);
          randCol = r.nextInt(Board.OCEAN_DIM - shipParts.length + 1);
          break;
        case VERTICAL:
          randRow = r.nextInt(Board.OCEAN_DIM - shipParts.length + 1);
          randCol = r.nextInt(Board.OCEAN_DIM);
          break;
      }
    } while (isShipOverlap(randRow, randCol, arr));

    putShipAt(randRow, randCol, arr);

    System.out.printf("the randomed values are: %s, %s, %s\n ", randRow, randCol, orientation);

  }

  public boolean isShipSunk() {
    for (ShipPart x : shipParts) {
      if (x.getHitStatus() != HitStatus.SUNK) {
        return false;
      }
    } 
    return true;
  }

  public boolean isAllShipPartsOfShipHit() {
    for (ShipPart x : shipParts) {
      if (x.getHitStatus() == HitStatus.UNHIT) {
        return false;
      }
    }
    return true;
  }

  public void markShipAsSunk() {
    for (ShipPart x : shipParts) {
      x.setHitStatus(HitStatus.SUNK);
    }
  }
}
