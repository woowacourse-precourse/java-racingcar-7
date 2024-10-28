package racingcar.car.exception;

public class NoSeparatorException extends RuntimeException {
    public NoSeparatorException() {
        super();
    }

    public NoSeparatorException(String message) {
        super(message);
    }

    public NoSeparatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSeparatorException(Throwable cause) {
        super(cause);
    }
}
