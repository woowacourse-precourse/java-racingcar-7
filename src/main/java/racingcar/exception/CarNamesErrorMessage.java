package racingcar.exception;

public enum CarNamesErrorMessage {
    CAR_NAME_EMPTY("자동차 이름이 비어 있습니다."),
    INVALID_DELIMITER("잘못된 구분자입니다."),
    CAR_NAME_OVER_FIVE("자동차 이름은 5자를 초과할 수 없습니다."),
    DUPLICATE_CAR_NAME("자동차 이름이 중복됩니다.");

    private final String message;

    CarNamesErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
