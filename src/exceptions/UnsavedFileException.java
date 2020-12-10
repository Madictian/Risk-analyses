package exceptions;

public class UnsavedFileException extends Exception {
    public UnsavedFileException() {
        super("An open file has not been saved");
    }
    public UnsavedFileException(String message) {
        super(message);
    }
    public UnsavedFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
