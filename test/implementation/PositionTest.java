package implementation;

import javafx.geometry.Pos;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {
    @Test
    public void isEqual() throws Exception {
        Position p1 = new Position(1,2);
        Position p2 = new Position(1,2);
        assertTrue(p1.isEqual(p2));
    }

    @Test
    public void isEqual2() throws Exception {
        Position p1 = new Position(1,2);
        Position p2 = new Position(2,2);
        assertFalse(p1.isEqual(p2));
    }

}