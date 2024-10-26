package racingcar.common;

public enum ErrorMessage {
    TOO_LONG_CAR_NAME("길이가 5 초과인 자동차 이름이 있습니다."),
    NO_CAR_NAME("자동차 이름이 입력되지 않았습니다."),
    TOO_MANY_CAR_NAME("자동차 이름이 100개 넘게 입력되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
