package racingcar.config.validation.exception;

public class ValidationException extends IllegalArgumentException {

    public ValidationException(String message) {
        super("[Validation Exception] " + message);
    }
}
