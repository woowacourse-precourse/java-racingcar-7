package racingcar.exception;

public class NonPositiveTryCountException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "시도 횟수는 양수만을 허용합니다.";

    public NonPositiveTryCountException() {
        super(DEFAULT_MESSAGE);
    }
}
