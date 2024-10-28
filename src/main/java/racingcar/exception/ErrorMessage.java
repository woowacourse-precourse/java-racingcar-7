package racingcar.exception;

public enum ErrorMessage {

    INVALID_INPUT_BLANK("빈 문자열을 입력할 수 없습니다."),
    INVALID_INPUT_FORMAT("잘못된 입력 형식입니다."),
    INVALID_CONTINUOUS_SEPARATOR("연속된 쉼표는 올 수 없습니다."),
    INVALID_COUNT_FORMAT("횟수는 양의 정수만 입력가능합니다."),
    INVALID_NAME_NOT_ENGLISH("이름은 영문자만 입력 가능합니다."),
    INVALID_NAME_OVER_FIVE("이름은 5글자를 초과할 수 없습니다."),
    INVALID_RACE_LIST_SIZE("시합은 두 명 이상부터 가능합니다."),
    INVALID_SAME_NAME("동일한 이름이 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
