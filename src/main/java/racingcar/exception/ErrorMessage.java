package racingcar.exception;

public enum ErrorMessage {
    // prefix
    ERROR_PREFIX("[ERROR] "),

    //  name
    INVALID_NAME_LENGTH("자동차 이름은 5자 이하만 가능합니다."),
    EMPTY_NAME("자동차 이름은 공백일 수 없습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message + message;
    }
}
