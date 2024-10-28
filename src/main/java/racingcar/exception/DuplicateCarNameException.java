package racingcar.exception;

public class DuplicateCarNameException extends IllegalArgumentException {

    private final static String ERROR_MESSAGE = "중복된 차 이름이 존재합니다.";

    public DuplicateCarNameException() {
        super(ERROR_MESSAGE);
    }
}
