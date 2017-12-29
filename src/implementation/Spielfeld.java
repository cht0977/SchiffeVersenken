package implementation;

import implementation.Exceptions.DaIstGarKeinSchiffException;
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

    @Override
    public TrefferErgebnis schuss(int x, int y) throws FeldBereitsBeschossenException{
        switch(felder[x][y].getZustand()) {
            case LEER: felder[x][y].setZustand(Feld.Zustand.LEERGETROFFEN);
                return TrefferErgebnis.WASSER;
            case SCHIFF: felder[x][y].setZustand(Feld.Zustand.SCHIFFGETROFFEN);
                try {
                    Schiff s = getSchiffZuTreffer(new Position(x, y));
                    boolean versenkt = SpielfeldChecker.schiffVersenkt(this, s);
                    if(versenkt) {
                        return TrefferErgebnis.TREFFERVERSENKT;
                    } else {
                        return TrefferErgebnis.TREFFER;
                    }
                } catch (DaIstGarKeinSchiffException e) {
                    e.printStackTrace();
                }
                return TrefferErgebnis.TREFFER;
            case LEERGETROFFEN: throw new FeldBereitsBeschossenException("Feld " + x + ": " + y + "  wurde bereits beschossen, aktueller Zustand: " + felder[x][y].toString());
            case SCHIFFGETROFFEN: throw new FeldBereitsBeschossenException("Feld " + x + ": " + y + "  wurde bereits beschossen, aktueller Zustand: " + felder[x][y].toString());
            default: throw new RuntimeException("Fehler in Funktion schuss, Zustand ist nicht definiert");
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

    public List<Schiff> getSchiffe() {
        return schiffe;
    }

    private Schiff getSchiffZuTreffer(Position treffer) throws DaIstGarKeinSchiffException {
        for(Schiff s: schiffe) {
            for(Position p: s.getPositionen()) {
                if(p.getX() == treffer.getX() && p.getY() == treffer.getY()) {
                    return s;
                }
            }
        }
        throw new DaIstGarKeinSchiffException("" + treffer.getX() + ":" + treffer.getY());
    }

    public void addSchiff(Schiff schiff) {
        Position[] positionen = schiff.getPositionen();
        for(Position p: positionen)
        {
            felder[p.getX()][p.getY()].setZustand(Feld.Zustand.SCHIFF);
        }
        schiffe.add(schiff);
    }

}
