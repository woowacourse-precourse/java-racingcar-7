package racingcar.exception;

public class RaceNotStartedException extends IllegalArgumentException {
    public RaceNotStartedException(String message) {
        super(message);
    }
}
