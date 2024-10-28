package racingcar.exception;

public enum ErrorCode {
    INVALID_INPUT_TYPE("차 이름은 영문자로 입력해주세요."),
    INVALID_CAR_NAME_LENGTH("차 이름은 1자 이상 5자 이내로 입력해주세요."),
    INVALID_TRY_COUNT_TYPE("시도할 횟수는 양수로 입력해주세요.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
