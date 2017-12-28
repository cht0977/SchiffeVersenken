package implementation;

import implementation.Exceptions.FeldBereitsBeschossenException;
import implementation.Exceptions.SchiffDarfNichtPlatziertWerdenException;

public interface SpielfeldInterface {

    /**
     *
     * @param x Der x-Wert der Position, an die geschossen werden soll
     * @param y Der y-Wert der Position, an die geschossen werden soll
     * @return Trrue: Der Schuss hat ein Schiff getroffen, False: Der Schuss hat kein Schiff getroffen
     * @throws FeldBereitsBeschossenException
     */
    boolean schuss(int x, int y) throws FeldBereitsBeschossenException;

    /**
     *
     * @param art KREUZER, SCHLACHTSCHIFF, ect
     * @param himmelsrichtung In welche Himmelsrichtung soll das Schiff platziert werden
     * @param position Die Position, die der Spieler zunächst geklickt hat.
     * @return True: Schiff wurde platziert, False: Schiff liegt nicht innerhalb der Grenzen oder berührt ein anderes Schiff
     * @throws SchiffDarfNichtPlatziertWerdenException
     */
    boolean platziereSchiff(Schiffart art, Himmelsrichtung himmelsrichtung, Position position) throws SchiffDarfNichtPlatziertWerdenException;
}
