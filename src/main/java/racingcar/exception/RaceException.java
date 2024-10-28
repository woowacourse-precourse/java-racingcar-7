package racingcar.exception;

public class RaceException extends IllegalArgumentException {

    private static final String PREFIX = "[ERROR] ";

    public RaceException(ErrorMessage message) {
        super(PREFIX + message.getMessage());
    }
}
