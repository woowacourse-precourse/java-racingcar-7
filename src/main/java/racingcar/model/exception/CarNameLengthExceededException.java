package racingcar.model.exception;

public class CarNameLengthExceededException extends IllegalArgumentException {
    public CarNameLengthExceededException(String message) {
        super(message);
    }
}
