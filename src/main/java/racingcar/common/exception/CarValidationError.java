package racingcar.common.exception;

public enum CarValidationError {

    NULL_OR_EMPTY_NAME_EXCEPTION("이름은 null 또는 빈 문자열일 수 없습니다."),
    INVALID_NAME_FORMAT_EXCEPTION("이름은 영어 또는 한글로만 이루어져 있어야 합니다."),
    EXCEEDS_MAX_NAME_LENGTH_EXCEPTION("이름은 %d자 이하여야 합니다."),
    LESS_THAN_MIN_CARS_COUNT_EXCEPTION("자동차는 %d대 이상이여야 합니다."),
    EXCEEDS_MAX_CARS_COUNT_EXCEPTION("자동차는 %d대 이하여야 합니다."),
    DUPLICATED_CARS_EXISTS_EXCEPTION("자동차는 중복된 이름을 가질 수 없습니다."),
    CAR_NOT_FOUND_EXCEPTION("해당 자동차를 찾을 수 없습니다."),
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
