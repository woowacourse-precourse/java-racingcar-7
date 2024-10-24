package racingcar.common.exception;

public enum ErrorMessage {
    EMPTY_INPUT("입력값이 비어 있습니다. 값을 입력해주세요."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
