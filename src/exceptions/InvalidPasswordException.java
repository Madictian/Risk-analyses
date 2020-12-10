package exceptions;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException() {
        super("The provided password was not valid");
    }
    public InvalidPasswordException(String message) {
        super(message);
    }
    public InvalidPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
