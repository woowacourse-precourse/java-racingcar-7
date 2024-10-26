package racingcar.error;

public enum ErrorMessage {
    INVALID_DELIMITER("구분자를 찾을 수 없습니다"),
    LONG_NAME_LENGTH("자동차 이름이 5자보다 깁니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
