package racingcar.exception;

public class NotNumberException extends RuntimeException {
    public NotNumberException() {
        super("숫자를 입력해야 합니다.");
    }
}
