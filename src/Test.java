/*
 * Test code for various functionality. Can be changed anytime 
 */
import shipcomponents.Ship;
import players.Computer;
import players.HuntTargetBot;

import java.util.List;
import java.util.Scanner;

public class Test {

  public void runTest() {
/*
    //human shoots at bot
    Computer computer = new Computer();
    Human human = new Human();
    
    computer.placeFleetOnBoard();
    computer.getBoard().printOcean();

    while (!computer.getBoard().isFleetSunk()) {
      human.fireAt(computer.getBoard());
      for (Ship x : computer.getBoard().getFleet()) {
        if (x.isAllShipPartsOfShipHit()) {
          System.out.printf("You have sunk bot's %s\n", x.getShipType().getName());
          x.markShipAsSunk();
        }
      }
      computer.getBoard().printOcean();
    }
*/
/*
    // bot shoots at human
    Computer computer = new Computer();
    Human human = new Human();
    
    human.placeFleetOnBoard();

    human.getBoard().printOcean();

    while (!human.getBoard().isFleetSunk()) {
      computer.fireAt(human.getBoard());
      for (Ship x : human.getBoard().getFleet()) {
        if (x.isAllShipPartsOfShipHit()) {
          System.out.printf("bot has sunk your %s\n", x.getShipType().getName());
          x.markShipAsSunk();
        }
      }
      human.getBoard().printOcean();
    }
*/

/*
    //bot2 shoots at bot1 (emptying the fleet)
    Computer computer = new Computer();
    computer.placeFleetOnBoard();
    computer.getBoard().printOcean();

    Computer computer2 = new Computer();

    while (!computer.getBoard().getFleet().isEmpty()) {
      computer2.fireAt(computer.getBoard());

      for (int i = 0; i < computer.getBoard().getFleet().size(); i++) {
        List<Ship> tmp = computer.getBoard().getFleet(); 
        if (tmp.get(i).isAllShipPartsOfShipHit()) {
          System.out.printf("bot2 has sunk bot1's %s\n", tmp.get(i).getShipType().getName());
          tmp.get(i).markShipAsSunk();
          tmp.remove(i);
        }

      }

      computer.getBoard().printOcean();
    }
*/

/*
    //bot2 shoots at bot1
    Computer computer = new Computer();
    computer.placeFleetOnBoard();
    computer.getBoard().printOcean();

    Computer computer2 = new Computer();

    while (!computer.getBoard().isFleetSunk()) {
      computer2.fireAt(computer.getBoard());

      for (Ship x : computer.getBoard().getFleet()) {
        if (x.isAllShipPartsOfShipHit()) {
          System.out.printf("bot1 has sunk bot2's %s\n", x.getShipType().getName());
          x.markShipAsSunk();
        }
      }

      computer.getBoard().printOcean();
    }
*/
/*
    //show points
    Computer computer = new Computer();
    computer.placeFleetOnBoard();
    computer.getBoard().printOcean();

    for (Ship x : computer.getBoard().getFleet()) {
      System.out.println(x.getShipType());
      for (ShipPart x1 : x.getShipParts()){
        System.out.println(x1.getPoint());
      }
    }
*/

    //HuntTargetBot shoots at bot1 
    Computer computer = new Computer();
    computer.placeFleetOnBoard();
    computer.getBoard().printOcean();

    HuntTargetBot computer2 = new HuntTargetBot();
    

    while (!computer.getBoard().getFleet().isEmpty()) {
      computer2.fireAt(computer.getBoard());

      for (int i = 0; i < computer.getBoard().getFleet().size(); i++) {
        List<Ship> tmp = computer.getBoard().getFleet(); 
        if (tmp.get(i).isAllShipPartsOfShipHit()) {
          System.out.printf("bot2 has sunk bot1's %s\n", tmp.get(i).getShipType().getName());
          tmp.get(i).markShipAsSunk();
          tmp.remove(i);
        }

      }

      computer.getBoard().printOcean();
    }

  }

}
