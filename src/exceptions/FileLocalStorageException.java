package exceptions;

public class FileLocalStorageException extends Exception {
    public FileLocalStorageException() {
        super("The file could not be saved locally");
    }
    public FileLocalStorageException(String message) {
        super(message);
    }
    public FileLocalStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
