package racingcar.exception;

public enum ErrorMessage {

    INVALID_INPUT_NAME_LENGTH("이름은 5자 이하만 가능합니다."),
    INVALID_INPUT_COUNT("숫자만 입력할 수 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
