package racingcar.exception;

public enum Exception {
    EMPTY_NAME("이름은 비거나 공백일 수 없습니다."),
    INVALID_NAME_LENGTH("이름은 5자 이내만 가능 합니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
