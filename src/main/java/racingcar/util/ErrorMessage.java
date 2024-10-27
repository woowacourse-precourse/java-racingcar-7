package racingcar.util;

public enum ErrorMessage {
    CAR_LIST_EMPTY_ERROR_MESSAGE("자동차 목록이 비어 있습니다."),
    DUPLICATE_CAR_NAME_ERROR_MESSAGE("중복된 자동차 이름이 있습니다."),
    INVALID_CAR_NAME_LENGTH_ERROR_MESSAGE("자동차의 이름은 1~5자여야 합니다."),
    INVALID_NUMBER_FORMAT_ERROR_MESSAGE("반복 횟수는 유효한 정수가 아닙니다."),
    NOT_NATURAL_NUMBER_ERROR_MESSAGE("반복 횟수는 양의 정수여야 합니다."),
    INVALID_POSITION_ERROR_MESSAGE("유효하지 않은 위치 값이 존재합니다.");

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String NEW_LINE = System.lineSeparator();

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message + NEW_LINE;
    }
}
