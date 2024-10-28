package racingcar.exception.errorMessage;

public enum ErrorMessage {
    INVALID_CAR_NAME("자동차 이름은 5자 이하여야 합니다."),
    DUPLICATED_CAR_NAME("시도 횟수는 1 이상이어야 합니다."),
    INVALID_ATTEMPT_NUMBER("시도 횟수는 1 이상이어야 합니다."),
    NOT_NUMBER_ATTEMPT("숫자가 아닌 값이 들어왔습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

