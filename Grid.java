/*
 * Implemented by Water and Ship class
 */
import java.awt.Point;

public interface Grid {

  HitStatus getHitStatus();
  char getIcon();
  void setHitStatus(HitStatus hitStatus); 
  Point getPoint();
}
