package racingcar.exception;

public enum ExceptionMessage {
    OVER_MAX_CAR_NAME("자동차의 이름은 최대 5자 입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
