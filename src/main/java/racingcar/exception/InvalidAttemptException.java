package racingcar.exception;

public class InvalidAttemptException extends IllegalArgumentException {
    public InvalidAttemptException(final String s) {
        super(s);
    }
}
