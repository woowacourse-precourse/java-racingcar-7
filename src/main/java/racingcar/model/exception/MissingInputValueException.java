package racingcar.model.exception;

public class MissingInputValueException extends IllegalArgumentException {
    public MissingInputValueException(String message) {
        super(message);
    }
}
