package racingcar.common;

public enum ErrorMessage {
    TOO_LONG_CAR_NAME("길이가 5 초과인 자동차 이름이 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
