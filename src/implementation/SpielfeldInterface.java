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


    boolean platziereSchiff(Schiffart art, Himmelsrichtung himmelsrichtung, Position position) throws SchiffDarfNichtPlatziertWerdenException;
}
