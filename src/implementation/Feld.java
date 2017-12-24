package implementation;

/*
Ein Feld eines Spielfeldes. Entweder befindet sich dort ein Schiff, oder nicht.
 */

public class Feld {
    enum Zustand {SCHIFF, LEER, SCHIFFGETROFFEN, LEERGETROFFEN};
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

    public String toString() {
        return zustand.toString();
    }
}
