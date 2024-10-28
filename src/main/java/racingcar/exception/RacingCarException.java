package racingcar.exception;

public class RacingCarException extends IllegalArgumentException {

    public RacingCarException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
