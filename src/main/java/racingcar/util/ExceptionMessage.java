package racingcar.util;

public enum ExceptionMessage {
    EMPTY_CAR("자동차가 없습니다."),
    DUPLICATE_CAR_NAME("같은 이름을 가진 자동차가 있습니다."),
    CAR_NAME_DELIMITER("자동차 이름은 1자 이상 5자 이하만 가능합니다."),
    HOLE_IN_RAIN("모든 자동차가 준비되지 않았습니다."),
    DO_NOT_OVER_MAX("시도 횟수는 최대값을 초과할 수 없습니다."),
    MUST_BE_INT("시도 횟수는 양의 정수여야 합니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(final String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String format() {
        return String.format(message);
    }
}