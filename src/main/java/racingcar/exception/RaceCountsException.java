package racingcar.exception;

public class RaceCountsException extends IllegalArgumentException {
    public RaceCountsException(RaceCountsErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}