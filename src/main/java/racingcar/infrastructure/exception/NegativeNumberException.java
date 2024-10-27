package racingcar.infrastructure.exception;

public class NegativeNumberException extends IllegalArgumentException {
    public NegativeNumberException() {
        super("양의 정수만 입력할 수 있습니다.");
    }
}
