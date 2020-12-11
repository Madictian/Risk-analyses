package exceptions;

public class UnsuccessfulFileCreationException extends Exception {
    public UnsuccessfulFileCreationException() {
        super("The file was not created successfully");
    }
    public UnsuccessfulFileCreationException(String message) {
        super(message);
    }
    public UnsuccessfulFileCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
