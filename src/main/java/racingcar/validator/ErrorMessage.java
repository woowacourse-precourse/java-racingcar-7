package racingcar.validator;

public enum ErrorMessage {
    EMPTY_OR_BLANK_INPUT_ERROR("입력이 비어있거나 공백일 수 없습니다."),
    NON_NUMERIC_INPUT_ERROR("입력값은 숫자여야 합니다."),
    CAR_NAME_LENGTH_ERROR("레이싱 카 이름의 길이는 1 이상 5 이하여야 합니다."),
    TOTAL_ATTEMPTS_OVERFLOW_ERROR("총 시도횟수는 정수 범위를 초과할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
