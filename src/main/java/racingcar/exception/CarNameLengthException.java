package racingcar.exception;

public class CarNameLengthException extends IllegalArgumentException {
    public CarNameLengthException() {
        super(ExceptionMessage.CAR_NAME_LENGTH_EXCEPTION_MESSAGE.getMessage());
    }
}
