package racingcar.car.exception;

public class NoPositionException extends RuntimeException {
    public NoPositionException() {
        super();
    }

    public NoPositionException(String message) {
        super(message);
    }

    public NoPositionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPositionException(Throwable cause) {
        super(cause);
    }
}
