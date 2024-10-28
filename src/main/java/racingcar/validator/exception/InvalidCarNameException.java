package racingcar.validator.exception;

public class InvalidCarNameException extends IllegalArgumentException {
    public InvalidCarNameException(String message) {
        super(message);
    }
}
