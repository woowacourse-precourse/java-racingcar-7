package racingcar.common.exception;

public enum CarValidationError {

    NULL_OR_EMPTY_NAME_EXCEPTION("이름은 null 또는 빈 문자열일 수 없습니다."),
    INVALID_NAME_FORMAT_EXCEPTION("이름은 영어 또는 한글로만 이루어져 있어야 합니다."),
    EXCEEDS_MAX_LENGTH_EXCEPTION("이름은 %d자 이하여야 합니다.");
    ;

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    CarValidationError(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
