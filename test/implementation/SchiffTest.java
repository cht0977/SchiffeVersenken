package implementation;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class SchiffTest {
    private Schiff testSchlachtSchiff;

    @Before
    public void setUp() throws Exception {
        Position pos = new Position(0,0);
        testSchlachtSchiff = new Schiff(Schiffart.SCHLACHTSCHIFF, pos, Himmelsrichtung.SUEDEN);
    }

    @Test
    public void getPositionen() throws Exception {
        Position[] positionsExpected = {new Position(0,0), new Position(0,1), new Position(0,2), new Position(0,3), new Position(0,4)};
        Position[] positionsReceived = testSchlachtSchiff.getPositionen();
        int[] xPositionsReceived = new int[5];
        int[] xPositionsExpected = new int[5];
        for(int i = 0; i < 5; i++) {
            xPositionsExpected[i] = positionsExpected[i].getX();
            xPositionsReceived[i] = positionsReceived[i].getX();
        }
        assertArrayEquals(xPositionsExpected, xPositionsReceived);
    }

    @Test
    public void getPositionen2() throws Exception {
        Position[] positionsExpected = {new Position(0,0), new Position(0,1), new Position(0,2), new Position(0,3), new Position(0,4)};
        Position[] positionsReceived = testSchlachtSchiff.getPositionen();
        int[] yPositionsReceived = new int[5];
        int[] yPositionsExpected = new int[5];
        for(int i = 0; i < 5; i++) {
            yPositionsExpected[i] = positionsExpected[i].getY();
            yPositionsReceived[i] = positionsReceived[i].getY();
        }
        assertArrayEquals(yPositionsExpected, yPositionsReceived);
    }

    @Test
    public void getName() throws Exception {
        assertEquals(testSchlachtSchiff.getName(), Schiffart.SCHLACHTSCHIFF);
    }

    @Test
    public void getHimmelsrichtung() throws Exception {
        assertEquals(testSchlachtSchiff.getHimmelsrichtung(), Himmelsrichtung.SUEDEN);
    }

}