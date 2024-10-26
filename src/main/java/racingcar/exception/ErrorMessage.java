package racingcar.exception;

public enum ErrorMessage {
    EMPTY_NAME("자동차 이름은 공백이 아니어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
