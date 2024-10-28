package racingcar.exception;

public class NotNumberException extends IllegalArgumentException {

    private static final String MESSAGE = "숫자가 입력되지 않았습니다.";

    public NotNumberException() {
        super(MESSAGE);
    }
}
