package racingcar.exception;

public enum RacingExceptionStatus {

    INVALID_NAME_LENGTH("자동차 이름은 5자 이하만 가능합니다."),
    INVALID_ATTEMPTS_INTEGER("입력된 시도 횟수가 올바르지 않습니다.");

    private final String message;

    RacingExceptionStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
