package exceptions;

public class UnsuccessfulPushException extends Exception {
    public UnsuccessfulPushException() {
        super("A file could not be pushed to the server");
    }
    public UnsuccessfulPushException(String message) {
        super(message);
    }
    public UnsuccessfulPushException(String message, Throwable cause) {
        super(message, cause);
    }
}
