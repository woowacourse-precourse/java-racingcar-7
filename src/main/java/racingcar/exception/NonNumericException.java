package racingcar.exception;

public class NonNumericException extends IllegalArgumentException {

    private final static String ERROR_MESSAGE = "숫자만 입력할 수 있습니다.";
    public NonNumericException() {
        super(ERROR_MESSAGE);
    }
}
