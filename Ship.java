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
