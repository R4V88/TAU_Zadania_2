package mockedunicorns.model;

public class UnicornAlreadyPairedException extends UnicornException {

    public UnicornAlreadyPairedException() {
    }

    public UnicornAlreadyPairedException(String message) {
        super(message);
    }

    public UnicornAlreadyPairedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnicornAlreadyPairedException(Throwable cause) {
        super(cause);
    }

    public UnicornAlreadyPairedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
