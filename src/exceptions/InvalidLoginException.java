package exceptions;

public class InvalidLoginException extends Exception {
    public InvalidLoginException() {
        super("The login information passed was not valid");
    }
    public InvalidLoginException(String message) {
        super(message);
    }
    public InvalidLoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
