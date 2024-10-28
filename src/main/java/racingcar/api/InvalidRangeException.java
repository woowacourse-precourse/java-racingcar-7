package racingcar.api;

public class InvalidRangeException extends RuntimeException {

    public InvalidRangeException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
