package racingcar.exception;

public class DuplicateCarException extends RuntimeException {
    public DuplicateCarException(String message) {
        super(message);
    }

    public DuplicateCarException() {
        super();
    }

    public DuplicateCarException(String message, Throwable cause) {
        super(message, cause);
    }
}
