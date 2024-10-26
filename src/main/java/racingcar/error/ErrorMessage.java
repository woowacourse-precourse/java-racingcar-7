package racingcar.error;

public enum ErrorMessage {
    INVALID_DELIMITER("구분자를 찾을 수 없습니다"),
    LONG_NAME_LENGTH("자동차 이름이 5자보다 깁니다"),
    OVERFLOW_NUMBER("숫자가 정수의 범위를 벗어났습니다"),
    INVALID_NUMBER("숫자가 아닌 값을 입력했습니다"),
    NON_POSITIVE_INTEGER("0이하의 숫자는 시도할 횟수가 될 수 없습니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
