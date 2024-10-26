package racingcar.exception;

public enum ErrorMessage {

    EMPTY_NAME("자동차 이름은 공백이 아니어야 합니다."),
    DUPLICATED_NAME("중복된 자동차 이름이 있습니다"),
    OVER_LENGTH_NAME("자동차 이름은 6자를 초과할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
