package racingcar.exception;

public class NegativeNumberException extends IllegalArgumentException {
    private static final String MESSAGE = "0이하의 수가 입력되었습니다.";

    public NegativeNumberException() {
        super(MESSAGE);
    }
}
