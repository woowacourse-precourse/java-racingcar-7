package racingcar.exception;

public enum ErrorStatus {
    // common
    EMPTY_INPUT("입력값이 없습니다."),

    // car
    INVALID_CAR_NAME("자동차 이름은 1자 이상 5자 이하만 가능합니다."),

    // round
    INVALID_ROUND_INPUT("라운드는 1 이상의 숫자만 가능합니다."),
    ROUND_OUT_OF_BOUND("라운드는 100 이하의 숫자만 가능합니다."),
    ;

    private final String message;

    ErrorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
