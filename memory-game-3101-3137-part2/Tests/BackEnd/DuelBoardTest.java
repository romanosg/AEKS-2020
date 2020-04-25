package BackEnd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DuelBoardTest {

    private Duel_Board testDuelBoard;

    @BeforeEach
    void initializer()
    {
        testDuelBoard = new Duel_Board();
    }

    @Test
    void TestGetRows()
    {
        assertEquals(6, testDuelBoard.getRows());
    }

    @Test
    void TestGetColumns()
    {
        assertEquals(4, testDuelBoard.getColumns());
    }

    @Test
    void TestGetNumberOfCardsInPlay()
    {
        assertEquals(24,testDuelBoard.getNumberOfPairsInPlay());
    }

    @Test
    void TestGameOver()
    {
        assertEquals(false, testDuelBoard.gameOver());
    }

    @Test
    void TestOpenAllCards()
    {
        boolean allCardsAreOpen = true;

        testDuelBoard.openAllCards();
        for (int i=0; i<2; i++)
        {
            for (int j=0; j<testDuelBoard.getTables()[i].length;j++){
                for (int k=0; k<testDuelBoard.getTables()[i][j].length;k++)
                {
                    if(!(testDuelBoard.getTables()[i][j][k].isOpen()))
                    {
                        allCardsAreOpen = false;
                        break;
                    }
                }
            }
        }

        assertEquals(true,allCardsAreOpen);
    }

    @Test
    void TestCloseAllCards()
    {
        boolean allCardsAreClosed = true;

        testDuelBoard.getTables()[0][3][1].setOpen(true);
        testDuelBoard.getTables()[1][5][2].setOpen(true);
        testDuelBoard.closeAllCards();

        testDuelBoard.openAllCards();
        for (int i=0; i<2; i++)
        {
            for (int j=0; j<testDuelBoard.getTables()[i].length;j++){
                for (int k=0; k<testDuelBoard.getTables()[i][j].length;k++)
                {
                    if(!(testDuelBoard.getTables()[i][j][k].isOpen()))
                    {
                        allCardsAreClosed = false;
                        break;
                    }
                }
            }
        }

        assertEquals(true,allCardsAreClosed);
    }
}
