package Exceptions;

public class UnSupportedRequestTypeException extends RuntimeException {
    public UnSupportedRequestTypeException() {
    }

    public UnSupportedRequestTypeException(String message) {
        super(message);
        System.out.println("Unsupported request type " + message);
    }

    public UnSupportedRequestTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnSupportedRequestTypeException(Throwable cause) {
        super(cause);
    }

    public UnSupportedRequestTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
