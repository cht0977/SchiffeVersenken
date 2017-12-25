package implementation;

public interface SpielfeldInterface {
    boolean schuss(int x, int y) throws Exception;
    boolean platziereSchiff(Schiffart art, Himmelsrichtung himmelsrichtung, Position position);
}
