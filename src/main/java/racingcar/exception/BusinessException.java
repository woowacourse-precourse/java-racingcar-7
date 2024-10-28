package racingcar.exception;

public class BusinessException extends IllegalArgumentException {

    public BusinessException(final RacingCarExceptionMessage message) {
        super(message.getErrorMessage());
    }
}
