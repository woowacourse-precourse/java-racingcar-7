package util.validator;

public enum Message {
    INVALID_DELIMITER("자동차 이름은 쉼표로 구분되어야 합니다."),
    INVALID_SINGLE_CAR_NAME("자동차는 2대 이상이어야 합니다."),
    INVALID_NAME_LENGTH("자동차 이름은 5자를 초과할 수 없습니다."),
    EMPTY_OR_NULL_NAME("자동차 이름에 공백이나 null 값이 포함될 수 없습니다."),
    INVALID_MIN_RACE_COUNT("반복 횟수는 1 이상으로 입력해야 합니다."),
    INVALID_MAX_RACE_COUNT("반복 횟수는 100 이하로 입력해야 합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
