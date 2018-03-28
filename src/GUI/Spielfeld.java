package GUI;

import implementation.*;
import implementation.Exceptions.FeldBereitsBeschossenException;
import implementation.Exceptions.SchiffDarfNichtPlatziertWerdenException;

import javax.swing.*;
import java.awt.*;

public class Spielfeld extends JPanel implements SpielfeldInterface{
    private Client clientGUI;
    private Feld[][] felder;
    static private final int spielFeldGroesse = 10;
    //TODO: Dieser Wert muss theoretisch abhängig von der Größe des Bildschirms und des Fensters gemacht werden
    static private final int defaultButtonSize = 50;

    public Spielfeld(Client clientGUI) {
        this.clientGUI = clientGUI;
        this.setLayout(new GridLayout(spielFeldGroesse, spielFeldGroesse));
        felder = new Feld[spielFeldGroesse][spielFeldGroesse];
        for(int x = 0; x < spielFeldGroesse; x++) {
            for(int y = 0; y < spielFeldGroesse; y++) {
                felder[x][y] = new Feld(defaultButtonSize, this, x, y);
                this.add(felder[x][y]);
            }
        }
    }

    /**
     * @param x Der x-Wert der Position, an die geschossen werden soll
     * @param y Der y-Wert der Position, an die geschossen werden soll
     * @return TREFFER: Der Schuss hat ein Schiff getroffen, VERSENKT: und versenkt, WASSER: Der Schuss hat kein Schiff getroffen
     * @throws FeldBereitsBeschossenException
     */
    @Override
    public TrefferErgebnis schuss(int x, int y) throws FeldBereitsBeschossenException {
        return null;
    }

    /**
     * @param art             KREUZER, SCHLACHTSCHIFF, ect
     * @param position        Die Position, die der Spieler zunächst geklickt hat.
     * @param himmelsrichtung In welche Himmelsrichtung soll das Schiff platziert werden
     * @return True: Schiff wurde platziert, False: Schiff liegt nicht innerhalb der Grenzen oder berührt ein anderes Schiff
     * @throws SchiffDarfNichtPlatziertWerdenException
     */
    @Override
    public boolean platziereSchiff(Schiffart art, Position position, Himmelsrichtung himmelsrichtung) throws SchiffDarfNichtPlatziertWerdenException {
        return false;
    }

    public void onFeldClick(Feld f) {
        Schiffart aktuellesSchiff = clientGUI.getSelectedSchiff();
        try {
            //TODO Wir brauchen noch die Himmelsrichtung -> Nutzer muss zwei mal klicken
            this.platziereSchiff(aktuellesSchiff, f.getPosition(), Himmelsrichtung.SUEDEN);
        }catch(SchiffDarfNichtPlatziertWerdenException e) {
            e.printStackTrace();
        }

        //Hier muss anschließend, falls platziereSchiff true liefert, die passenden Felder gesetzt werden
    }
}
