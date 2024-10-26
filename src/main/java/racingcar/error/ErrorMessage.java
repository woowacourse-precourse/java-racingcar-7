package racingcar.error;

public enum ErrorMessage {
    INVALID_DELIMITER("구분자를 찾을 수 없습니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
