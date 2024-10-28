package racingcar.exception;

public class SingleCarNameException extends IllegalArgumentException {

    private final static String ERROR_MESSAGE = "자동차의 이름은 두 개 이상 입력해야 합니다.";
    public SingleCarNameException() {
        super(ERROR_MESSAGE);
    }
}
