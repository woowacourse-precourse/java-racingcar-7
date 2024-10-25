package racingcar.exception;

public class CountFormatException extends RuntimeException {

    private final static String ERROR_MESSAGE = "입력된 시도 횟수의 형태가 올바르지 않습니다.";

    public CountFormatException() {
        super(ERROR_MESSAGE);
    }
}
