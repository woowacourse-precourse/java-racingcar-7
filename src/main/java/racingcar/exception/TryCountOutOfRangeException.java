package racingcar.exception;

public class TryCountOutOfRangeException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "시도할 횟수는 1 이상 100 이하여야 합니다.";

    public TryCountOutOfRangeException() {
        super(ERROR_MESSAGE);
    }
}
