package racingcar.exception;

public enum ErrorMessage {
    NOT_INTEGER("횟수 입력은 숫자만 입력할 수 있습니다."),
    INVALID_COUNT_RANGE("횟수는 1회 이상이여야합니다."),
    INVALID_NAME_LENGTH("자동차 이름은 1글자 이상, 5글자 이하여야합니다."),
    INVALID_NAME_COUNT("자동차 이름은 2개 이상 입력해야합니다."),
    NAME_DUPLICATE("중복된 이름이 없어야합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
