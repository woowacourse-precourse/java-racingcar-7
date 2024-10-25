package racingcar.model.exception;

public class InvalidAttemptCountException extends IllegalArgumentException {
    public InvalidAttemptCountException(String message) {
        super(message);
    }
}
