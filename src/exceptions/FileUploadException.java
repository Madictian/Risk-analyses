package exceptions;

public class FileUploadException extends Exception {
    public FileUploadException() {
        super("The file could not be uploaded successfully");
    }
    public FileUploadException(String message) {
        super(message);
    }
    public FileUploadException(String message, Throwable cause) {
        super(message, cause);
    }
}
