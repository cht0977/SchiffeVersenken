package implementation;

public class Schiff {

    private Schiffart name;
    private int laenge;

    public Schiff(Schiffart name) {
        this.name = name;
        this.laenge = initiiereLaenge();
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
}
