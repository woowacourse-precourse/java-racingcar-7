package racingcar.validator.exception;

public class InvalidCarCountException extends IllegalArgumentException {
    public InvalidCarCountException(String message) {
        super(message);
    }
}
