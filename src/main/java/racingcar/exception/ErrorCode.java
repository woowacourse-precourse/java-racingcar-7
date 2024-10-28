package racingcar.exception;

public enum ErrorCode {
    INVALID_CAR_NAME("자동차 이름은 5자 이하여야 합니다."),
    INVALID_TRY_COUNT("시도 횟수는 1 이상이어야 합니다."),
    TRY_COUNT_IS_NOT_NUMBER("시도 횟수는 숫자로 입력해야 합니다."),
    ;

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
