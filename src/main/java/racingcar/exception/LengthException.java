package racingcar.exception;

public class LengthException extends Exception {

    private static final String MESSAGE = "자동차 이름은 5자리 이하여야 합니다.";

    public LengthException() {
        super(MESSAGE);
    }

}
