package by.epam.exception;

public class InfoHandlingException extends Exception {

    public InfoHandlingException() {
        super();
    }

    public InfoHandlingException(Throwable cause) {
        super(cause);
    }

    public InfoHandlingException(String message) {
        super(message);
    }

    public InfoHandlingException(String message, Throwable cause) {
        super(message, cause);
    }

    public InfoHandlingException(Throwable cause, String message) {
        super(message, cause);
    }
}
