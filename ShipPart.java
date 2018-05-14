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
  public void setHitStatus(HitStatus hitStatus) {
    this.hitStatus = hitStatus;
  }

}
