package racingcar.global;

public enum ErrorMessage {
    INVALID_CAR_NAME_LENGTH("자동차 이름은 1자 이상 5자 이하만 가능합니다."),
    INVALID_CAR_NAME_CONTAINS_SPACE("자동차 이름에 공백이 포함되어 있습니다."),
    INVALID_ROUND_COUNT("시도 횟수는 1 이상의 숫자만 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
