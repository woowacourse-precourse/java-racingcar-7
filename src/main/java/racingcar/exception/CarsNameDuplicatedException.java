package racingcar.exception;

public class CarsNameDuplicatedException extends IllegalArgumentException {
    public CarsNameDuplicatedException(String message) {
        super(message);
    }
}
