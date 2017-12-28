package implementation.Exceptions;

/**
 * Ein Schiff sollte platziert werden, obwohl die maximale Anzahl der Schiffe bereits erreicht ist
 */
public class SchiffDarfNichtPlatziertWerdenException extends Exception{
    public SchiffDarfNichtPlatziertWerdenException(String msg) {
        super("SchiffDarfNichtPlatziertWerdenException: " + msg);
    }
}
