package racingcar.exception;

public class CarNameContainEmptyException extends IllegalArgumentException {
    public CarNameContainEmptyException(String message) {
        super(message);
    }
}
