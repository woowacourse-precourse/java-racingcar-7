package racingcar;

public enum ErrorMessage {
    DUPLICATE_CAR_NAME("자동차 이름은 중복되어서는 안된다."),

    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
