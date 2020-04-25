/**
 * @author Georgios Romanos
 */

package BackEnd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class CPUTest {

    private Board testBoardNormal;
    private Duel_Board testBoardDuel;

    @BeforeEach
    void CreateBoard()
    {
        testBoardNormal = new Board(4,6,2);
        testBoardDuel = new Duel_Board();
    }

    @Test
    void ElephantTestNormal()
    {
        CPU Elephant = new CPU("Elephant", 3, testBoardNormal);
        Elephant.memorize(1,2,3);
        Elephant.memorize(3,5,3);
        Point[] testpoint = Elephant.pickCard();
        boolean P1 = (((int) testpoint[0].getX() == 1) && ((int) testpoint[0].getY() == 2));
        boolean P2 = (((int) testpoint[1].getX() == 3) && ((int) testpoint[1].getY() == 5));
        boolean P3 = Elephant.getName().equals("Elephant");
        boolean P = P1&&P2&&P3;
        assertEquals(true, P);
    }

    @Test
    void ElephantTestDuel()
    {
        CPU Elephant = new CPU("", 3, testBoardDuel, 0);
        Elephant.memorize(2,0,3);
        Point[] testpoint = Elephant.pickCardDuelRespond(3);
        boolean P1 = (((int) testpoint[0].getX() == 2) && ((int) testpoint[0].getY() == 0));
        boolean P2 = Elephant.getName().equals("");
        boolean P = P1&&P2;
        assertEquals(true, P);
    }
}
