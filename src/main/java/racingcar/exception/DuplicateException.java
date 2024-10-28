package racingcar.exception;

public class DuplicateException extends Exception {

    private static final String MESSAGE = "중복된 값이 존재합니다.";

    public DuplicateException() {
        super(MESSAGE);
    }
}
