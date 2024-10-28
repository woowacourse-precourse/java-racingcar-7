package racingcar.exception;

public enum ErrorMessage {

    EMPTY_NAME("입력값은 공백이 아니어야 합니다."),
    DUPLICATED_NAME("중복된 자동차 이름이 있습니다"),
    OVER_LENGTH_NAME("자동차 이름은 6자를 초과할 수 없습니다."),
    INVALID_ATTEMPT_COUNT_FORMAT("입력된 시도 횟수는 숫자여야 합니다."),
    OVERFLOW_INTEGER("입력된 숫자가 정수의 최대 범위를 초과합니다."),
    NEGATIVE_NUMBER("입력된 숫자는 양수여야 합니다."),
    NOT_INTEGER("입력된 시도 횟수는 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
