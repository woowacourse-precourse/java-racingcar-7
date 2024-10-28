package racingcar.exception;

public class CarNamesException extends IllegalArgumentException {
    public CarNamesException(CarNamesErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}