package racingcar.exception;

public enum ErrorMessage {
    NULL_INPUT_ERROR("null은 입력할 수 없습니다."),
    EMPTY_INPUT_ERROR("빈 문자열은 입력할 수 없습니다."),
    TRY_COUNT_INVALID("시도할 횟수는 최소 1 이상의 양의 정수이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
