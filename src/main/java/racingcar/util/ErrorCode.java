package racingcar.util;

public enum ErrorCode {

    INVALD_INPUT("잘못된 입력입니다"),
    CAR_LIMIT_EXCEEDED("자동차는 최대 1000대까지 가능합니다"),
    INVALID_CAR_NAME("이름은 5자 이하여야 합니다"),
    DUPLICATE_CAR_NAME("중복된 자동차 이름이 있습니다"),
    INVALID_MOVE_COUNT("이동 횟수는 1회 이상 1000회 이하여야 합니다");


    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public IllegalArgumentException exception() {
        return new IllegalArgumentException(this.message);
    }

    public String getMessage() {
        return message;
    }
}
