package exception;

public class CustomIllegalArgException extends IllegalArgumentException {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public CustomIllegalArgException(String message) {
        super(ERROR_PREFIX + message);
    }
}
