package racingcar.error;

public enum ErrorCode {

    INVALID_ATTEMPT_COUNT("시도 횟수는 %d회 이상이어야 합니다."),
    INVALID_CAR_NAME("자동차 이름은 %d자 이상 %d자 이하이어야 합니다.");

    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage(Object... args) {
        return String.format(errorMessage, args);
    }
}
