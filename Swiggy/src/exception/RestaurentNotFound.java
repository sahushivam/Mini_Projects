package exception;

public class RestaurentNotFound extends RuntimeException{

    public RestaurentNotFound() {
    }

    public RestaurentNotFound(String message) {
        super(message);
    }

    public RestaurentNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public RestaurentNotFound(Throwable cause) {
        super(cause);
    }

    public RestaurentNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
