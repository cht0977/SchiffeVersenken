package implementation.Exceptions;

public class DaIstGarKeinSchiffException extends Exception{
    public DaIstGarKeinSchiffException(String msg) {
        super("DaIstGarKeinSchiffException: " + msg);
    }
}
