package racingcar.exception;

public class BlankException extends IllegalArgumentException {

    private static final String MESSAGE = "자동차 이름은 공백일 수 없습니다.";

    public BlankException() {
        super(MESSAGE);
    }
}
