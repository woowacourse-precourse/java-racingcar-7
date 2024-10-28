package racingcar.enums;

public enum ExceptionMessage {
    EMPTY_CAR_NAMES("자동차 이름을 입력해 주세요."),
    SINGLE_CAR_NAME("자동차의 이름은 2개 이상 입력해 주세요."),
    DUPLICATE_CAR_NAMES("자동차 이름은 중복될 수 없습니다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름은 5자 이하만 가능합니다."),
    EMPTY_CAR_NAME("자동차 이름은 공백일 수 없습니다."),
    ATTEMPTS_LESS_THAN_ONE("시도 횟수는 1회 이상이어야 합니다."),
    INVALID_ATTEMPTS_NUMBER("유효한 숫자를 입력해주세요."),
    CAR_NOT_FOUND("자동차가 존재하지 않습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
