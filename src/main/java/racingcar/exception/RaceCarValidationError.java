package racingcar.exception;

public enum RaceCarValidationError implements ErrorMessage {
    CARS_NULL("자동차 배열은 null이 될 수 없습니다."),
    CARS_EXCEED_LIMIT("자동차는 10대 이하여야 합니다."),
    CARS_DUPLICATE_NAME("자동차 이름은 중복될 수 없습니다.");

    private final String message;

    RaceCarValidationError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
