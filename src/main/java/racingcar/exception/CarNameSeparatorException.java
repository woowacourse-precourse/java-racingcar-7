package racingcar.exception;

public class CarNameSeparatorException extends IllegalArgumentException {
    public CarNameSeparatorException() {
        super(ExceptionMessage.CAR_NAME_SEPARATOR_EXCEPTION_MESSAGE.getMessage());
    }
}
