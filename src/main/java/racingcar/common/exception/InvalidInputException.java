package racingcar.common.exception;

public class InvalidInputException extends IllegalArgumentException {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String INVALID_INPUT_FORMAT_EXCEPTION = "잘못된 입력 형식입니다.";

    public InvalidInputException(String message) {
        super(message);
    }

    public static InvalidInputException forInvalidInput() {
        return new InvalidInputException(ERROR_PREFIX + INVALID_INPUT_FORMAT_EXCEPTION);
    }
}
