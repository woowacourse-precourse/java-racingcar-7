package racingcar.exception;

public class RacingCarGameException extends IllegalArgumentException {
    private RacingCarGameException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static RacingCarGameException from(ErrorMessage errorMessage) {
        return new RacingCarGameException(errorMessage);
    }
}
