package racingcar.exception.executionNumber;

public class NotNumberException extends IllegalArgumentException {

    public NotNumberException() {
        super("숫자를 입력해야 합니다.");
    }
}
