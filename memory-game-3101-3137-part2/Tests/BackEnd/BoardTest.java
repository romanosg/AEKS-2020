package BackEnd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board testBoard;

    @BeforeEach
    void initializer()
    {
        testBoard = new Board(3,5,3);
    }

    @Test
    void TestgetRows() {
        int testRows = testBoard.getRows();
        assertEquals(3,testRows);
    }

    @Test
    void TestgetColumns() {
        int testColumns = testBoard.getColumns();
        assertEquals(5,testColumns);
    }

    @Test
    void TestgetSameCopies() {
        int testSameCopies = testBoard.getSameCopies();
        assertEquals(3,testSameCopies);
    }

    @Test
    void TestgetNumberOfCardsInPlay() {
        int testNumberOfCardsInPlay = testBoard.getNumberOfCardsInPlay();
        assertEquals(15,testNumberOfCardsInPlay);
    }

    @Test
    void TestOpenAllCards()
    {
        boolean allCardsAreOpen = true;
        testBoard.openAllCards();
        for(int i=0; i<testBoard.getTable().length;i++)
        {
            for(int k=0; k<testBoard.getTable()[i].length; k++)
            {
                if (!(testBoard.getTable()[i][k].isOpen()))
                {
                    allCardsAreOpen = false;
                    break;
                }
            }
        }

        assertEquals(true, allCardsAreOpen);
    }

    @Test
    void TestCloseAllCards()
    {
        boolean allCardsAreClosed = true;
        testBoard.getTable()[1][2].setOpen(true);
        testBoard.getTable()[0][0].setOpen(true);
        testBoard.closeAllCards();
        for(int i=0; i<testBoard.getTable().length;i++)
        {
            for(int k=0; k<testBoard.getTable()[i].length; k++)
            {
                if (testBoard.getTable()[i][k].isOpen())
                {
                    allCardsAreClosed = false;
                    break;
                }
            }
        }
        assertEquals(true, allCardsAreClosed);
    }

    @Test
    void TestGameOver()
    {
        assertEquals(false,testBoard.gameOver());
    }
}
