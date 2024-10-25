package racingcar.exception;

public enum ExceptionType {

    NAME_TOO_LONG("이름이 너무 깁니다.", IllegalArgumentException.class),
    NAME_CANNOT_BE_NULL("이름은 null 이 될 수 없습니다.", IllegalArgumentException.class),
    NAME_CANNOT_BE_BLANK("이름은 공백일 수 없습니다.", IllegalArgumentException.class),

    EMPTY_CARS("자동차는 1대 이상이어야 합니다.", IllegalArgumentException.class),
    DUPLICATED_CARS("중복된 자동차가 존재합니다.", IllegalArgumentException.class),

    TRY_COUNT_TOO_SMALL("시도 횟수가 너무 적습니다.", IllegalArgumentException.class),

    MIN_GREATER_THAN_MAX("최소값이 최대값보다 클 수 없습니다.", IllegalArgumentException.class),

    INVALID_TRY_COUNT("유효하지 않은 시도 횟수입니다.", IllegalArgumentException.class);

    private final String message;
    private final Class<? extends RuntimeException> exceptionClass;

    ExceptionType(String message, Class<? extends RuntimeException> exceptionClass) {
        this.message = message;
        this.exceptionClass = exceptionClass;
    }

    public String getMessage() {
        return message;
    }

    public Class<? extends RuntimeException> getExceptionClass() {
        return exceptionClass;
    }
}
