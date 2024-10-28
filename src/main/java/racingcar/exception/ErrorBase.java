package racingcar.exception;

public enum ErrorBase {
    INPUT_IS_EMPTY("빈 문자열입니다."),
    CAR_NAME_IS_BETWEEN_ONE_AND_FIVE("자동차 이름은 [1,5] 이내여야 합니다."),
    CAR_COUNT_EXCEEDS_LIMIT("자동차는 1대 이상, 1000대 이하여야 합니다."),

    ROUNDS_COUNT_INVALID("시도 횟수는 1회 이상, 1000회 이하여야 합니다."),
    ROUNDS_MUST_BE_NUMBER("시도 횟수는 숫자여야 합니다.");

    private final String message;

    ErrorBase(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
