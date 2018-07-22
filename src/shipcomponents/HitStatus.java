/*
 * Describes the status of objects that implement the Grid interface
 * the status changes after it has been hit by the opposing player.
 * The SUNK status exclusively indicates when all ShipParts of a Ship are hit.
 */
package shipcomponents;

public enum HitStatus {

  UNHIT,
  HIT,
  SUNK;
}
