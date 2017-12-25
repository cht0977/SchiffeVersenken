package implementation;

import java.util.LinkedList;
import java.util.List;

public class SpielfeldChecker {

    public static boolean schiffPasst(Spielfeld spielfeld, Schiff schiff) {
        if(schonBelegt(spielfeld, schiff) || ausserhalbDesFeldes(schiff))
        {
            return false;
        } else {
            return true;
        }
    }

    private static boolean schonBelegt(Spielfeld spielfeld, Schiff schiff) {
        Schiff[] schiffe = spielfeld.getSchiffe();
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
}
