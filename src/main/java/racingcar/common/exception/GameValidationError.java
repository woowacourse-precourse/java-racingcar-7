package racingcar.common.exception;

public enum GameValidationError {

    LESS_THAN_MIN_TRY_COUNT_EXCEPTION("라운드는 %d회 이상이여야 합니다."),
    EXCEEDS_MAX_TRY_COUNT_EXCEPTION("라운드는 %d회 이하여야 합니다."),
    ;

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    GameValidationError(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
