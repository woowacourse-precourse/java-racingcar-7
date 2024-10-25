package racingcar.model.exception;

public class DuplicateCarNameException extends IllegalArgumentException {
    public DuplicateCarNameException(String message) {
        super(message);
    }
}