package mockedunicorns.model;

public class UnicornException extends Exception {

    public UnicornException() {
    }

    public UnicornException(String message) {
        super(message);
    }

    public UnicornException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnicornException(Throwable cause) {
        super(cause);
    }

    public UnicornException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
