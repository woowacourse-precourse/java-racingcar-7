package racingcar.error;

public enum TryCountErrorMessage {
    INVALID_TRY_COUNT("숫자로만 작성해 주세요"),
    REQUIRED_TRY_COUNT("1회 이상 시도해야 합니다.");

    private final String message;

    TryCountErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
