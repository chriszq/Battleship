/*
 * All Ship Types that each player possess. There are two ships with length 3.
 */
package shipcomponents;

public enum ShipType {
  
  CARRIER ("Carrier", 5),
  BATTLESHIP ("Battleship", 4),
  CRUISER ("Cruiser", 3),
  SUBMARINE ("Submarine", 3),
  DESTROYER ("Destroyer", 2);

  private final String name;
  private final int length;

  private ShipType(String name, int length) {
    this.name = name;
    this.length = length;
  }

  public String getName() {
    return this.name;
  }

  public int getLength() {
    return this.length;
  }
}
