package exception;

public class DocumentNotFound extends RuntimeException {


    public DocumentNotFound() {
        super();
    }

    public DocumentNotFound(String message) {
        super(message);
    }

    public DocumentNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public DocumentNotFound(Throwable cause) {
        super(cause);
    }

    protected DocumentNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
