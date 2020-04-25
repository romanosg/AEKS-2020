/**
 * @author Konstantinos Stavratis
 */

package BackEnd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class Name_and_Score_Test {

    private Name_and_Score testNameAndScore;

    @BeforeEach
    void testNameAndScoreConstructor()
    {
        testNameAndScore = new Name_and_Score("Tester",15);
    }

    @Test
    void ConstructorTest()
    {
        assertEquals(15,testNameAndScore.getScore());
        assertEquals("Tester",testNameAndScore.getName());
    }

    @Test
    void testSetAndGetName()
    {
        testNameAndScore.setName("NotTester");
        String name = testNameAndScore.getName();
        assertEquals("NotTester",name);
    }

    @Test
    void testSetAndGetScore()
    {
        testNameAndScore.setScore(16);
        int testscore = testNameAndScore.getScore();
        assertEquals(16,testscore);
    }

}
