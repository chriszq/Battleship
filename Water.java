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
  public void fireAt() {
    switch (hitStatus) {
      case UNHIT:
        setHitStatus(HitStatus.HIT);
        System.out.println("you missed");
        break;
      case HIT:
        System.out.println("you already fired at this spot");
        break;
      default:
        System.out.println("error occured. cannot sink empty spot ");
        break;
    }
  }

  public void setHitStatus(HitStatus hitStatus) {
    this.hitStatus = hitStatus;
  }
}
