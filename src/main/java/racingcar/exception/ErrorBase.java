package racingcar.exception;

public enum ErrorBase {
    CAR_NAME_IS_EMPTY("자동차 이름이 비어있습니다."),
    CAR_NAME_IS_BETWEEN_ONE_AND_FIVE("자동차 이름은 [1,5] 이내여야 합니다."),
    CAR_COUNT_EXCEEDS_LIMIT("자동차는 1대 이상, 1000대 이하여야 합니다.");

    private final String message;

    ErrorBase(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
