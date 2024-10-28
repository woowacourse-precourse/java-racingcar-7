package racingcar.exception;

public enum ErrorMessage {
    INPUT_MUST_BE_NOT_NULL("공백은 입력할 수 없습니다."),
    CAR_NAME_LENGTH_OVER_FIVE("자동차의 이름은 5자 이하여야 합니다."),
    CAR_NAME_MUST_UNIQUE("차 이름은 중복할 수 없습니다."),
    INPUT_ROUND_COUNT_MUST_BE_NUMERIC("숫자가 아닌 문자가 포함되어 있습니다."),
    INPUT_ROUND_COUNT_MUST_BE_POSITIVE("게임의 횟수는 1 이상이어야 합니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
