package racingcar.exception;

public class RacingCarException extends IllegalArgumentException {
    public RacingCarException(RacingCarErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
