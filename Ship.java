/*
 * A Ship can be one of the (five) ShipTypes. The number of ShipParts represents the Ship length,
 * e.g. Battleship contains 4 ShipParts because it has length 4.
 * All ShipParts belonging to a Ship are considered SUNK only after they have all been HIT.
 * When this happens the Ship is considered SUNK.
 */

public class Ship {

  private ShipType shipType;
  private ShipPart[] shipParts;
  private Orientation orientation;

  public Ship(ShipType shipType) {
    this.shipType = shipType;
    this.shipParts = new ShipPart[shipType.getLength()];

    for (int i = 0, n = this.shipParts.length; i < n; i++) {
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

  public void setOrientation(Orientation orientation) {
    this.orientation = orientation;
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
      if (x.getHitStatus() == HitStatus.UNHIT || x.getHitStatus() == HitStatus.SUNK) {
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
