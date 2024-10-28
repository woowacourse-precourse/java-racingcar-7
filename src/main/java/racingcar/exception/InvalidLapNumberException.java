package racingcar.exception;

public class InvalidLapNumberException extends RacingCarException {
    private static final String MESSAGE = "게임 횟수는 오직 양수만 가능합니다.";
    public InvalidLapNumberException() {
        super(MESSAGE);
    }
}
