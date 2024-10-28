package racingcar.exception;

public class RaceException extends IllegalArgumentException {
    private final ErrorMessage errorMessage;

    public RaceException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
