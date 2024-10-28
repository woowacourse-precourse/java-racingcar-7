package racingcar.exception;

public class RacingException extends IllegalArgumentException {
    public RacingException(String message) {
        super(message);
    }

    public static RacingException from(String message) {
        return new RacingException(message);
    }
}
