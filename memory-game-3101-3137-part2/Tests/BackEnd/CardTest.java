package BackEnd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    private Card testCard;

    @BeforeEach
    void cardInitializer()
    {
        testCard = new Card(35);
    }

    @Test
    void TestGetId() {
        int testId = testCard.getId();
        assertEquals(35,testId);
    }

    @Test
    void TestIsOpen() {
        boolean testOpen = testCard.isOpen();
        assertEquals(false,testOpen);
    }

    @Test
    void TestSetOpen() {
        boolean testOpen;
        for (int i=0;i<9;i++)
        {
            testCard.setOpen(!testCard.isOpen());
        }
        testOpen = testCard.isOpen();
        assertEquals(true,testOpen);
    }

}
