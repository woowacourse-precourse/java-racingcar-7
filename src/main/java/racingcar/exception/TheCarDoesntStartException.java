package racingcar.exception;

public class TheCarDoesntStartException extends IllegalArgumentException {

    public TheCarDoesntStartException() {
        super("자동차가 출발하지 않았습니다.");
    }
}
