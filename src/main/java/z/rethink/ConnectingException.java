package z.rethink;

public class ConnectingException extends RuntimeException {
    public ConnectingException() {
    }

    public ConnectingException(String message) {
        super(message);
    }

    public ConnectingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectingException(Throwable cause) {
        super(cause);
    }

    public ConnectingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
