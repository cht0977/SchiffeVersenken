package implementation;

/*
Ein Feld eines Spielfeldes. Entweder befindet sich dort ein Schiff, oder nicht.
 */

public class Feld {
    enum Zustand {SCHIFF, LEER};
    private Zustand zustand;

    public Feld() {
        zustand = Zustand.LEER;
    }

    public Zustand getZustand() {
        return zustand;
    }

    public void setZustand(Zustand zustand) {
        this.zustand = zustand;
    }
}
