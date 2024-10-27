package racingcar.exception;

public class CarNameDuplicationException extends IllegalArgumentException {
    public CarNameDuplicationException() {
        super(ExceptionMessage.CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE.getMessage());
    }
}
