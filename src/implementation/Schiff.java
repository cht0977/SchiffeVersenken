package implementation;

public class Schiff {

    private Schiffart name;
    private int laenge;
    private Position position;
    private Himmelsrichtung himmelsrichtung;

    public Schiff(Schiffart name, Position position) {
        this.name = name;
        this.laenge = initiiereLaenge();
        this.position = position;
    }

    public Schiff(Schiffart name, Position position, Himmelsrichtung himmelsrichtung) {
        this.name = name;
        this.laenge = initiiereLaenge();
        this.position = position;
        this.himmelsrichtung = himmelsrichtung;

    }

    public int initiiereLaenge() {
        switch(name)  {
            case SCHLACHTSCHIFF: return 5;
            case UBOOT: return 2;
            case KREUZER: return 4;
            case ZERSTÖRER: return 3;
            default: throw new IllegalArgumentException();
        }
    }

    public Schiffart getName() {
        return name;
    }

    public void setName(Schiffart name) {
        this.name = name;
    }

    public int getLaenge() {
        return laenge;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Himmelsrichtung getHimmelsrichtung() {
        return himmelsrichtung;
    }

    public void setHimmelsrichtung(Himmelsrichtung himmelsrichtung) {
        this.himmelsrichtung = himmelsrichtung;
    }
}
