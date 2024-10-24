package racingcar.exception;

public class NumberRangeException extends RuntimeException {
    public NumberRangeException(String message) {
        super("허용가능한 숫자 범위를 넘어섰습니다. 1,000,000 이내의 숫자를 적어주세요.");
    }
}
