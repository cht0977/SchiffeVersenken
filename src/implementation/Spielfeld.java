package implementation;

import implementation.Exceptions.FeldBereitsBeschossenException;
import implementation.Exceptions.SchiffDarfNichtPlatziertWerdenException;

import java.util.LinkedList;
import java.util.List;

public class Spielfeld implements SpielfeldInterface{


    private Feld[][] felder;
    private List<Schiff> schiffe;

    public Spielfeld() {
        felder = new Feld[10][10];
        for(int x = 0; x < 10; x++) {
            for(int y = 0; y < 10; y++) {
                felder[x][y] = new Feld();
            }
        }
        schiffe = new LinkedList<>();
    }

    public boolean schuss(int x, int y) throws FeldBereitsBeschossenException{
        switch(felder[x][y].getZustand()) {
            case LEER: felder[x][y].setZustand(Feld.Zustand.LEERGETROFFEN);
                return false;
            case SCHIFF: felder[x][y].setZustand(Feld.Zustand.SCHIFFGETROFFEN);
                return true;
            case LEERGETROFFEN: throw new FeldBereitsBeschossenException("Feld " + x + ": " + y + "  wurde bereits beschossen, aktueller Zustand: " + felder[x][y].toString());
            case SCHIFFGETROFFEN: throw new FeldBereitsBeschossenException("Feld " + x + ": " + y + "  wurde bereits beschossen, aktueller Zustand: " + felder[x][y].toString());
            default: System.out.println("Fehler in Funktion schuss, Zustand ist nicht definiert");
                return false;
        }
    }

    @Override
    public boolean platziereSchiff(Schiffart art, Himmelsrichtung himmelsrichtung, Position position) throws SchiffDarfNichtPlatziertWerdenException{
        Schiff schiff = new Schiff(art, position, himmelsrichtung);
        boolean schiffErlaubt = SpielfeldChecker.schiffErlaubt(getSchiffe(), schiff);
        if(!schiffErlaubt) {
            throw new SchiffDarfNichtPlatziertWerdenException("Maximale Anzahl an Schiffen erreicht");
        }
        boolean schiffPasst = SpielfeldChecker.schiffPasst(this, schiff);
        if(schiffPasst) {
            addSchiff(schiff);
            return true;
        } else {
            return false;
        }
    }

    public Feld[][] getFelder() {
        return felder;
    }

    public void setFelder(Feld[][] felder) {
        this.felder = felder;
    }

    public List<Schiff> getSchiffe() {
        return schiffe;
    }

    public void setSchiffe(List<Schiff> schiffe) {
        this.schiffe = schiffe;
    }

    public void addSchiff(Schiff schiff) {
        schiffe.add(schiff);
    }

}
