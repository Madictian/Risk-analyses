package exceptions;

public class UnsuccessfulFileDeletionException extends Exception {
    public UnsuccessfulFileDeletionException() {
        super("The file was not deleted successfully");
    }
    public UnsuccessfulFileDeletionException(String message) {
        super(message);
    }
    public UnsuccessfulFileDeletionException(String message, Throwable cause) {
        super(message, cause);
    }
}
