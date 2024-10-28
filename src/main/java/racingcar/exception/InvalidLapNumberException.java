package racingcar.exception;

public class InvalidLapNumberException extends RacingCarException {
    private static final String MESSAGE = "게임 횟수는 '2_147_483_647' 이하의 양수만 가능합니다.";
    public InvalidLapNumberException() {
        super(MESSAGE);
    }
}
