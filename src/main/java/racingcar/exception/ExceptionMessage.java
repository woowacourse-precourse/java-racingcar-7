package racingcar.exception;

public enum ExceptionMessage {
    EMPTY_CAR_NAMES("자동차 이름이 입력되지 않았습니다."),
    TOO_LONG_NAME("자동차 이름은 5자 이하만 가능합니다."),
    INVALID_CAR_NAME("자동차 이름이 유효하지 않습니다."),
    BOUNDARY_DELIMITER("앞,뒤에 구분자(,)가 존재할 수 없습니다."),
    INSUFFICIENT_CARS("자동차는 2대 이상 필요합니다."),

    EMPTY_ATTEMPT_COUNT("시도할 횟수가 입력되지 않았습니다."),
    INVALID_ATTEMPT_COUNT("1 이상의 자연수만 입력할 수 있습니다."),
    OUT_OF_BOUNDS_ATTEMPT_COUNT("횟수는 1 이상 1000 이하이어야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
