package exceptions;

public class UsernameNotFoundException extends Exception {
    public UsernameNotFoundException() {
        super("The provided username was not found");
    }
    public UsernameNotFoundException(String message) {
        super(message);
    }
    public UsernameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
