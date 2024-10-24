package racingcar.exception;

public class CountNegativeException extends RuntimeException {

    private final static String message = "시도 횟수는 양수만 입력할 수 있습니다.";

    public CountNegativeException() {
        super(message);
    }
}
