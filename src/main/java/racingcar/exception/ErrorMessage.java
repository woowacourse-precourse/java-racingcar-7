package racingcar.exception;

public enum ErrorMessage {
    EMPTY_CAR_NAMES("경주할 자동차 이름이 비어있습니다."),
    INSUFFICIENT_CARS("경주할 자동차는 2대 이상이어야 합니다."),
    DUPLICATE_CAR_NAMES("자동차 이름이 중복되었습니다."),
    CAR_NAME_TOO_LONG("자동차 이름은 5글자를 초과할 수 없습니다."),
    EMPTY_ATTEMPTS("시도할 횟수는 비어있을 수 없습니다."),
    INVALID_ATTEMPTS("유효하지 않은 시도 횟수입니다."),
    RANDOM_VALUE_OUT_OF_BOUNDS("랜덤 값이 유효한 범위를 초과했습니다."),
    EMPTY_CAR_NAME("자동차 이름은 빈 값이 될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}