/*
 * Represents part of a Ship. Each Ship is made of an Array of ShipParts.
 * Changes it's display icon depending on HitStatus.
 */

package shipcomponents;

import java.awt.Point;

public class ShipPart implements Grid {

  private Point point;
  private HitStatus hitStatus;

  public ShipPart() {
    this.point = new Point(-1, -1);
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
        return 'o';
      case HIT: 
        return '!';
      case SUNK:
        return '@';
      default:
        return '?';
    }
  }

  @Override
  public void setHitStatus(HitStatus hitStatus) {
    this.hitStatus = hitStatus;
  }

  @Override
  public Point getPoint() {
    return this.point;
  }

  @Override
  public String toString() {
    return String.format("%s", point);
  }

}
