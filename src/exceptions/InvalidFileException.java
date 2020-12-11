package exceptions;

public class InvalidFileException extends Exception {
    public InvalidFileException() {
        super("The file provided was invalid");
    }
    public InvalidFileException(String message) {
        super(message);
    }
    public InvalidFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
