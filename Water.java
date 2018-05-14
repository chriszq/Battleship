/*
 * Represents the water that surrounds all the ships.
 * Water and Ship objects are indistinguishable to the opposing player until they have been hit.
 */

public class Water implements Grid {

  private HitStatus hitStatus;

  public Water() {
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
        return 'x';
      default:
        return '?';
    }
  }

  @Override
  public void setHitStatus(HitStatus hitStatus) {
    this.hitStatus = hitStatus;
  }
}
