package racingcar.domain.exception;

public class InvalidTryCountInput extends IllegalArgumentException {

    public InvalidTryCountInput() {
        super("시도 횟수가 유효하지 않습니다.");
    }
}
