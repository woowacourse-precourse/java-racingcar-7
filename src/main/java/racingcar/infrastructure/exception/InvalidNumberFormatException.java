package racingcar.infrastructure.exception;

public class InvalidNumberFormatException extends IllegalArgumentException {
    public InvalidNumberFormatException() {
        super("숫자 형식이 올바르지 않습니다.");
    }
}
