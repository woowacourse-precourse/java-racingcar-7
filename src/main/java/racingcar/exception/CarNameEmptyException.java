package racingcar.exception;

public class CarNameEmptyException extends IllegalArgumentException {
    public CarNameEmptyException() {
        super(ExceptionMessage.CAR_NAME_EMPTY_EXCEPTION_MESSAGE.getMessage());
    }
}
