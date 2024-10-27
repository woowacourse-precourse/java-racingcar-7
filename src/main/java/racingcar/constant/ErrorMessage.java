package racingcar.constant;

public enum ErrorMessage {
    INVALID_CAR_NAME_LENGTH("자동차 이름은 5자 이하만 가능합니다."),
    MISSING_CAR_NAME("자동차 이름은 공백일 수 없습니다."),
    UNEXPECTED_COMMA("입력이 쉼표로 끝날 수 없습니다."),
    DUPLICATE_CAR_NAME("자동차 이름은 중복될 수 없습니다."),
    INSUFFICIENT_CAR_NAMES("자동차 이름은 두 개 이상 입력해야 합니다."),
    INVALID_ATTEMPTS("시도 횟수는 1 이상이어야 합니다."),
    NON_NUMERIC_ATTEMPTS("시도 횟수는 숫자여야 합니다."),
    EMPTY_INPUT("입력 값이 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
