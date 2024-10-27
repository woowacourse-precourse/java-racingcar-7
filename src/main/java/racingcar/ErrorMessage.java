package racingcar;

public enum ErrorMessage {
    NULL_INPUT("입력값이 필요합니다."),
    BLANK_INPUT("입력값은 공백이 될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}