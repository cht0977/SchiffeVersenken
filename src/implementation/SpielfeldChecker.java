package implementation;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SpielfeldChecker {
    private static final int ANZAHL_SCHLACHTSCHIFF = 1;
    private static final int ANZAHL_KREUZER = 2;
    private static final int ANZAHL_ZERSTOERER = 3;
    private static final int ANZAHL_UBOOT = 4;

    /**
     *
     * @param spielfeld
     * @param schiff
     * @return TRUE: Das Schiff passt, FALSE: Das Schiff passt nicht
     */
    public static boolean schiffPasst(Spielfeld spielfeld, Schiff schiff) {
        //TODO: Das Schiff darf auch nicht an ein anderes angrenzen
        if(schonBelegt(spielfeld, schiff) || ausserhalbDesFeldes(schiff) || imUmkreisEinesSchiffes(spielfeld, schiff))
        {
            return false;
        } else {
            return true;
        }
    }


    /**
     *
     * @param schiffe Das Schiff Array des Spielfeldes
     * @param schiff Das zu platzierende Schiff
     * @return TRUE: Die maximale Anzahl der Schiff erlaubt es das Schiff zu platzieren, FALSE: NICHT
     */
    public static boolean schiffErlaubt(List<Schiff> schiffe, Schiff schiff){
        if(schiffe.size() >= 10) {
            return false;
        }
        Schiffart art = schiff.getName();
        int maxAnzahlArt = 0;
        switch(art) {
            case SCHLACHTSCHIFF:
                maxAnzahlArt = ANZAHL_SCHLACHTSCHIFF;
                break;
            case ZERSTÖRER:
                maxAnzahlArt = ANZAHL_ZERSTOERER;
                break;
            case KREUZER:
                maxAnzahlArt = ANZAHL_KREUZER;
                break;
            case UBOOT:
                maxAnzahlArt = ANZAHL_UBOOT;
                break;
        }
        for(Schiff s: schiffe) {
            if(s.getName() == art) {
                maxAnzahlArt -= 1;
            }
        }

        if(maxAnzahlArt > 0) {
            return true;
        }else {
            return false;
        }
    }

    /**
     *
     * @param spielfeld
     * @param schiff Das getroffene Schiff
     * @return TRUE: Das Schiff ist versenkt, FALSE: Das Schiff wurde nicht versenkt
     */
    public static boolean schiffVersenkt(Spielfeld spielfeld, Schiff schiff)
    {
        Position[] positionen = schiff.getPositionen();
        Feld[][] felder = spielfeld.getFelder();
        boolean versenkt = true;
        for(Position p: positionen) {
            if(versenkt && felder[p.getX()][p.getY()].getZustand() == Feld.Zustand.SCHIFFGETROFFEN) {
                continue;
            } else {
                versenkt = false;
            }
        }
        return versenkt;
    }


    private static boolean schonBelegt(Spielfeld spielfeld, Schiff schiff) {
        List<Schiff> schiffe = spielfeld.getSchiffe();
        for(Schiff s: schiffe) {
            for(Position p: s.getPositionen()) {
                for(Position p2: schiff.getPositionen()) {
                    if(p2.isEqual(p)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean ausserhalbDesFeldes(Schiff schiff) {
        Position[] positionen = schiff.getPositionen();
        for(Position p: positionen) {
            if(p.getX() < 0 || p.getX() > 9 || p.getY() < 0 ||p.getY() > 9) {
                return true;
            }
        }
        return false;
    }

    private static boolean imUmkreisEinesSchiffes(Spielfeld spielfeld, Schiff schiff) {
        List<Position> positionen = new LinkedList<>();
        for(Schiff s: spielfeld.getSchiffe()) {
            positionen.addAll(getUmliegendeFelder(s));
        }
        //TODO: DAS IST NUR EIN TEST, WEGEN REFERENZÜBERGABE UND SO
        loescheUnnoetigePositionen(positionen);

        for(Position pSchiff: loescheUnnoetigePositionen(getUmliegendeFelder(schiff))) {
            for(Position pAndereSchiffe: positionen) {
                if(pSchiff.isEqual(pAndereSchiffe)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    Diese Funktion gibt, im Gegensatz zu dem, was der Name behauptet, alle zu einem Schiff "gehörenden" Felder zurück
     */
    private static List<Position> getUmliegendeFelder(Schiff s) {
        List<Position> positionen = new LinkedList<>();
        for(Position p: s.getPositionen()) {
            positionen.add(p);
            positionen.add(new Position(p.getX()-1, p.getY()-1));
            positionen.add(new Position(p.getX()-1, p.getY()));
            positionen.add(new Position(p.getX()-1, p.getY()+1));
            positionen.add(new Position(p.getX()+1, p.getY()-1));
            positionen.add(new Position(p.getX()+1, p.getY()));
            positionen.add(new Position(p.getX()+1, p.getY()+1));
            positionen.add(new Position(p.getX(), p.getY()-1));
            positionen.add(new Position(p.getX(), p.getY()+1));
        }
        return positionen;
    }

    private static List<Position> loescheUnnoetigePositionen(List<Position> positionen) {

        Position lastValue = null;
        for(Iterator<Position> i = positionen.iterator(); i.hasNext();) {
            Position currentValue = i.next();
            if(lastValue != null && currentValue.isEqual(lastValue)) {
                i.remove();
            }
            lastValue = currentValue;
        }

        for(Position p: positionen) {
            if(p.getX() < 0 || p.getX() > 9 || p.getY() < 0 || p.getY() > 9) {
                positionen.remove(p);
            }
        }
        return positionen;
    }
}
