package racingcar.exception;

public class RoundNumberFormatException extends IllegalArgumentException {

    public RoundNumberFormatException() {
        super("경주 횟수는 숫자만 입력 가능합니다.");
    }
}
