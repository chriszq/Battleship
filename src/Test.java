/*
 * Test code for various functionality. Can be changed anytime 
 */
import board.Board;
import shipcomponents.Ship;
import players.Computer;
import players.Human;
import players.HuntTargetBot;

import java.util.List;
import java.util.Scanner;

public class Test {

  public void runTest() {
/*
    //bot2 shoots at bot1
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


/*
    //human shoots at bot
    Computer computer = new Computer();

    Human human = new Human();
    
    computer.placeFleetOnBoard();
    computer.getBoard().printOcean();

    while (!computer.getBoard().getFleet().isEmpty()) {
      human.fireAt(computer.getBoard());

      for (int i = 0; i < computer.getBoard().getFleet().size(); i++) {
        List<Ship> tmp = human.getBoard().getFleet();
        if (tmp.get(i).isAllShipPartsOfShipHit()) {
          System.out.printf("you have sunk has bot's %s\n", tmp.get(i).getShipType().getName());
          tmp.get(i).markShipAsSunk();
          tmp.remove(i);
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

    while (!human.getBoard().getFleet().isEmpty()) {
      computer.fireAt(human.getBoard());

      for (int i = 0; i < human.getBoard().getFleet().size(); i++) {
        List<Ship> tmp = human.getBoard().getFleet();
        if (tmp.get(i).isAllShipPartsOfShipHit()) {
          System.out.printf("bot2 has sunk your %s\n", tmp.get(i).getShipType().getName());
          tmp.get(i).markShipAsSunk();
          tmp.remove(i);
        }
      }
      human.getBoard().printOcean();
    }
*/

  }

}
