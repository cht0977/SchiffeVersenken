package implementation;

public class Schiff {

    private Schiffart name;
    private int laenge;
    private Position[] positionen;
    private Himmelsrichtung himmelsrichtung;

    /**
     *
     * @param name Schiffart
     * @param position StartPosition, aus dme positionen errechnet wird
     * @param himmelsrichtung
     */
    public Schiff(Schiffart name, Position position, Himmelsrichtung himmelsrichtung) {
        this.name = name;
        this.laenge = initiiereLaenge();
        this.himmelsrichtung = himmelsrichtung;
        fuellePositionen(position);
    }

    /**
     *
     * @param name Schiffart
     * @param positionen Position[] hat alle Positionen des Schiffes
     * @param himmelsrichtung
     */
    public Schiff(Schiffart name, Position[] positionen, Himmelsrichtung himmelsrichtung) {
        this.name = name;
        this.laenge = positionen.length;
        this.positionen = positionen;
        this.himmelsrichtung = himmelsrichtung;
    }

    private int initiiereLaenge() {
        switch(name)  {
            case SCHLACHTSCHIFF: return 5;
            case UBOOT: return 2;
            case KREUZER: return 4;
            case ZERSTOERER: return 3;
            default: throw new IllegalArgumentException();
        }
    }

    private void fuellePositionen(Position p) {
           this.positionen = new Position[laenge];
           positionen[0] = p;
           for(int i = 1; i < laenge; i++) {
               switch(himmelsrichtung) {
                   case OSTEN: p.setX(p.getX()+1);
                   case NORDEN: p.setY(p.getY()-1);
                   case SUEDEN: p.setY(p.getY()+1);
                   case WESTEN: p.setX(p.getX()-1);
               }
               positionen[i] = p;
           }
    }

    public Position[] getPositionen() {
        return positionen;
    }

    public Schiffart getName() {
        return this.name;
    }

    public Himmelsrichtung getHimmelsrichtung() {
        return himmelsrichtung;
    }
}
