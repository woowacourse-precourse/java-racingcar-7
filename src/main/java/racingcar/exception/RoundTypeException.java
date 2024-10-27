package racingcar.exception;

public class RoundTypeException extends IllegalArgumentException {
    public RoundTypeException() {
        super(ExceptionMessage.RACING_ROUND_NUMBER_EXCEPTION_MESSAGE.getMessage());
    }
}
