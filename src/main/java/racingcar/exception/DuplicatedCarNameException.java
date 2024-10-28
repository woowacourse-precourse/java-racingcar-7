package racingcar.exception;

public class DuplicatedCarNameException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "중복되지 않은 이름으로 입력해주세요.";

    public DuplicatedCarNameException() {
        super(DEFAULT_MESSAGE);
    }
}
