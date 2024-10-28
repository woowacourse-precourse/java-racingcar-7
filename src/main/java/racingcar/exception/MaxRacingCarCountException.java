package racingcar.exception;

public class MaxRacingCarCountException extends IllegalArgumentException {

    public MaxRacingCarCountException() {
        super("경주에 참가할 수 있는 최대 자동차 수는 10대입니다.");
    }
}
