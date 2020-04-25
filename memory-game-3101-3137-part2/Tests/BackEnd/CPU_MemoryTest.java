/**
 * @author Georgios Romanos
 * @author Konstantinos Stavratis
 */

package BackEnd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class CPU_MemoryTest {

    private CPU_Memory testCPU_Memory;

    @BeforeEach
    void createTestCPU()
    {
        testCPU_Memory = new CPU_Memory(2);
    }


    @Test
    void testLength()
    {
        testCPU_Memory.addPoint(5,7);
        testCPU_Memory.addPoint(2,6);
        testCPU_Memory.addPoint(5,7);
        assertEquals(2,testCPU_Memory.getLength());
    }

    @Test
    void testGetCoordinates()
    {
        testCPU_Memory.addPoint(2,3);
        testCPU_Memory.addPoint(2,3);
        testCPU_Memory.addPoint(4,1);
        Point[] testpoint = testCPU_Memory.getCoordinates();
        boolean p1 = (((int) testpoint[0].getX() == 2) && ((int) testpoint[0].getY() == 3));
        boolean p2 = (((int) testpoint[1].getX() == 4) && ((int) testpoint[1].getY() == 1));
        boolean p = p1&&p2;
        assertEquals(true, p);

    }
}
