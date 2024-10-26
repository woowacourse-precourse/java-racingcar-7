package racingcar.exception;

public class RoundNumberRangeException extends IllegalArgumentException {
    public RoundNumberRangeException() {
        super(ExceptionMessage.RACING_ROUND_POSITIVE_NUMBER_EXCEPTION_MESSAGE.getMessage());
    }
}
