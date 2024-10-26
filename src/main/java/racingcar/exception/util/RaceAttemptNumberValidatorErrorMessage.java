package racingcar.exception.util;

public enum RaceAttemptNumberValidatorErrorMessage {
    INVALID_NUMBER_FORMAT("시도 횟수는 숫자여야 합니다."),
    NUMBER_TOO_LOW("시도 횟수는 1 이상이어야 합니다.");

    private final String message;

    RaceAttemptNumberValidatorErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
