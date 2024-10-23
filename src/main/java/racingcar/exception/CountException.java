package racingcar.exception;

public class CountException extends RuntimeException {

    private final static String message = "입력된 시도 횟수가 올바르지 않습니다.";

    public CountException() {
        super(message);
    }
}
