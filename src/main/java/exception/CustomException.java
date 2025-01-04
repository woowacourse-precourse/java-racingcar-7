package exception;

public class CustomException {

    public static final String ERROR_PREFIX = "[ERROR] ";

    public static void throwException(String message) {
        throw new IllegalArgumentException(ERROR_PREFIX + message);
    }

}
