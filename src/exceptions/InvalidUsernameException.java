package exceptions;

public class InvalidUsernameException extends Exception {
    public InvalidUsernameException() {
        super("The provided username was not valid");
    }
    public InvalidUsernameException(String message) {
        super(message);
    }
    public InvalidUsernameException(String message, Throwable cause) {
        super(message, cause);
    }
}
