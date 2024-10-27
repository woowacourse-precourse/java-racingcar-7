package racingcar.exception;

public enum ErrorType {

    EXCEEDED_MAXIMUM_CAR_NAME_LENGTH("자동차 이름은 최대 5자입니다."),
    DUPLICATE_CAR_NAME("자동차 이름이 중복됩니다."),
    EXCEEDED_MAXIMUM_COUNT("시도 횟수는 최대 10회입니다."),
    INVALIDED_COUNT_TYPE("시도 횟수는 숫자이어야 합니다.");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
