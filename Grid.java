/*
 * Implemented by Water and Ship class
 */

public interface Grid {

  HitStatus getHitStatus();
  char getIcon();
  void setHitStatus(HitStatus hitStatus); 
}
