package BackEnd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player testPlayer;

    @BeforeEach
    void playerCreation() {
        testPlayer = new Human_Player("Konstantinos");
    }


    @Test
    void madeMove() {
        for (int i=0; i<10; i++)
            testPlayer.madeMove();
        int testMoves = testPlayer.getMoves();
        assertEquals(10,testMoves);
    }

    @Test
    void completedPair() {
        for (int i=0; i<15; i++)
        {
            testPlayer.completedPair();
        }
        int testPairs = testPlayer.getPairs();
        assertEquals(15,testPairs);

    }


    @Test
    void won() {
        for (int i=0; i<3; i++)
        {
            testPlayer.won();
        }
        int testVictories = testPlayer.getWins();
        assertEquals(3,testVictories);
    }

    @Test
    void getName()
    {
        assertEquals("Konstant",testPlayer.getName());
    }
}