package exceptions;

public class UnsuccessfulPullException extends Exception {
    public UnsuccessfulPullException() {
        super("A file could not be pulled from the server");
    }
    public UnsuccessfulPullException(String message) {
        super(message);
    }
    public UnsuccessfulPullException(String message, Throwable cause) {
        super(message, cause);
    }
}
