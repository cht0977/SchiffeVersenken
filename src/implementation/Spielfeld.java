package implementation;

import implementation.Exceptions.FeldBereitsBeschossenException;

public class Spielfeld implements SpielfeldInterface{
    private final int ANZAHL_SCHLACHTSCHIFF = 1;
    private final int ANZAHL_KREUZER = 2;
    private final int ANZAHL_ZERSTOERER = 3;
    private final int ANZAHL_UBOOT = 4;

    private Feld[][] felder;
    private Schiff[] schiffe;

    public Spielfeld() {
        felder = new Feld[10][10];
        for(int x = 0; x < 10; x++) {
            for(int y = 0; y < 10; y++) {
                felder[x][y] = new Feld();
            }
        }
    }

    /*
    Auf das feld x, y wird geschossen, gibt bei treffer true zurück, sonst false
     */
    public boolean schuss(int x, int y) throws Exception{
        switch(felder[x][y].getZustand()) {
            case LEER: felder[x][y].setZustand(Feld.Zustand.LEERGETROFFEN);
                return false;
            case SCHIFF: felder[x][y].setZustand(Feld.Zustand.SCHIFFGETROFFEN);
                return true;
            case LEERGETROFFEN: throw new FeldBereitsBeschossenException("Feld " + x + ": " + y + "  wurde bereits beschossen, aktueller Zustand: " + felder[x][y].toString());
            case SCHIFFGETROFFEN: throw new FeldBereitsBeschossenException("Feld " + x + ": " + y + "  wurde bereits beschossen, aktueller Zustand: " + felder[x][y].toString());
            default: throw new RuntimeException("Hier zu kann es eigentlich nicht kommen");
        }
    }

    @Override
    public boolean platziereSchiff(Schiffart art, Himmelsrichtung himmelsrichtung, Position position) {
        return true;
    }

    public Feld[][] getFelder() {
        return felder;
    }

    public void setFelder(Feld[][] felder) {
        this.felder = felder;
    }

    public Schiff[] getSchiffe() {
        return schiffe;
    }

    public void setSchiffe(Schiff[] schiffe) {
        this.schiffe = schiffe;
    }

}
