package racingcar.exception;

public enum ErrorMessage {

    CAR_NAME_TOO_LONG("자동차 이름은 5자 이하여야 합니다."),
    INVALID_ATTEMPT_COUNT("시도 횟수는 숫자여야 합니다."),
    ATTEMPT_COUNT_CANNOT_BE_ZERO("시도 횟수는 0 이상의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
