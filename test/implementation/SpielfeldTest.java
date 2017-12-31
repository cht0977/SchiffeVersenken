package implementation;

import implementation.Exceptions.SchiffDarfNichtPlatziertWerdenException;
import jdk.nashorn.internal.runtime.ECMAException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpielfeldTest {
    private Spielfeld s;
    @Before
    public void setUp() throws Exception {
        s = new Spielfeld();
    }

    @Ignore
    @Test
    public void schuss() throws Exception {
    }

    /*
    Schiff links außerhalb des Feldes
     */
    @Test
    public void platziereSchiff1() throws Exception {
        boolean platziert = s.platziereSchiff(Schiffart.SCHLACHTSCHIFF, new Position(3, 0), Himmelsrichtung.WESTEN);
        assertFalse(platziert);
    }

    /*
    Schiff oben außerhalb des Feldes
     */
    @Test
    public void platziereSchiff2() throws Exception {
        boolean platziert = s.platziereSchiff(Schiffart.SCHLACHTSCHIFF, new Position(0, 3), Himmelsrichtung.NORDEN);
        assertFalse(platziert);
    }

    /*
    Schiff rechts außerhalb des Feldes
     */
    @Test
    public void platziereSchiff3() throws Exception {
        boolean platziert = s.platziereSchiff(Schiffart.SCHLACHTSCHIFF, new Position(6, 9), Himmelsrichtung.OSTEN);
        assertFalse(platziert);
    }

    /*
    Schiff unten außerhalb des Feldes
     */
    @Test
    public void platziereSchiff4() throws Exception {
        boolean platziert = s.platziereSchiff(Schiffart.SCHLACHTSCHIFF, new Position(9, 6), Himmelsrichtung.SUEDEN);
        assertFalse(platziert);
    }

    /*
    Schiff links geradeso im Feld
    */
    @Test
    public void platziereSchiff5() throws Exception {
        boolean platziert = s.platziereSchiff(Schiffart.SCHLACHTSCHIFF, new Position(4, 0), Himmelsrichtung.WESTEN);
        assertTrue(platziert);
    }

    /*
    Schiff oben geradeso im Feld
     */
    @Test
    public void platziereSchiff6() throws Exception {
        boolean platziert = s.platziereSchiff(Schiffart.SCHLACHTSCHIFF, new Position(0, 4), Himmelsrichtung.NORDEN);
        assertTrue(platziert);
    }

    /*
    Schiff rechts geradeso im Feld
     */
    @Test
    public void platziereSchiff7() throws Exception {
        boolean platziert = s.platziereSchiff(Schiffart.SCHLACHTSCHIFF, new Position(5, 9), Himmelsrichtung.OSTEN);
        assertTrue(platziert);
    }

    /*
    Schiff unten geradeso im Feld
     */
    @Test
    public void platziereSchiff8() throws Exception {
        boolean platziert = s.platziereSchiff(Schiffart.SCHLACHTSCHIFF, new Position(9, 5), Himmelsrichtung.SUEDEN);
        assertTrue(platziert);
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Spielfeld feld = new Spielfeld();
    }

}