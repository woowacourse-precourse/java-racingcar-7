package racingcar.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(final RacingCarExceptionMessage message) {
        super(message.getErrorMessage());
    }
}
