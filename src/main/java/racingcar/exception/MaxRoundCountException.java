package racingcar.exception;

public class MaxRoundCountException extends IllegalArgumentException {

    public MaxRoundCountException() {
        super("경주 횟수는 최대 50회까지 입력 가능합니다.");
    }
}
