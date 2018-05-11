public class ShipPart implements Grid {

  private HitStatus hitStatus;

  public ShipPart() {
    this.hitStatus = HitStatus.UNHIT;
  }

  @Override
  public HitStatus getHitStatus() {
    return this.hitStatus;
  }

  @Override
  public char getIcon() {
    switch (hitStatus) {
      case UNHIT:
        return '-';
      case HIT: 
        return '@';
      case SUNK:
        return '#';
      default:
        return '?';
    }
  }

  @Override
  public void fireAt() {
    switch (hitStatus) {
      case UNHIT:
        setHitStatus(HitStatus.HIT);
        System.out.println("you hit something");
        break;
      case HIT:
        System.out.println("you already hit something here");
        break;
      case SUNK:
        System.out.println("you already sunk this ship");
        break;
    }
  }

  public void setHitStatus(HitStatus hitStatus) {
    this.hitStatus = hitStatus;
  }

  public boolean isShipPartOverlap(int row, int col, Grid[][] arr) {
    return (arr[row][col].getClass() == ShipPart.class) ? true : false;
  }

  public void putShipPartAt(int row, int col, Grid[][] arr) {
    arr[row][col] = this;
  }
}
