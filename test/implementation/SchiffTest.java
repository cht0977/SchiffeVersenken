package implementation;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SchiffTest {
    private Schiff testSchiff;

    @Before
    public void setUp() throws Exception {
        Position pos = new Position(0,0);
        testSchiff = new Schiff(Schiffart.SCHLACHTSCHIFF, pos, Himmelsrichtung.SUEDEN);
    }

    @Test
    public void getPositionen() throws Exception {
        Position[] positionsExpected = {new Position(0,0), new Position(0,1), new Position(0,2), new Position(0,3), new Position(0,4)};
        Position[] positionsReceived = testSchiff.getPositionen();
        int[] xPositionsReceived = new int[5];
        int[] yPositionsReceived = new int[5];
        int[] xPositionsExpected = new int[5];
        int[] yPositionsExpected = new int[5];
        for(int i = 0; i < 5; i++) {
            xPositionsExpected[i] = positionsExpected[i].getX();
            yPositionsExpected[i] = positionsExpected[i].getY();
            xPositionsReceived[i] = positionsReceived[i].getX();
            yPositionsReceived[i] = positionsReceived[i].getY();
        }
        assertArrayEquals(xPositionsExpected, xPositionsReceived);
        //TODO umschreiben, assertArrayEquals bricht ab.
    }

    @Ignore
    @Test
    public void getName() throws Exception {
    }

    @Ignore
    @Test
    public void getHimmelsrichtung() throws Exception {
    }

}