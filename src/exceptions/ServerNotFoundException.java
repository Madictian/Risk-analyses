package exceptions;

public class ServerNotFoundException extends Exception {
    public ServerNotFoundException() {
        super("The servers could not be reached");
    }
    public ServerNotFoundException(String message) {
        super(message);
    }
    public ServerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
