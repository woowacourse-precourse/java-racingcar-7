package racingcar.game.constant;

public enum ExceptionMessage {
    INVALID_RACING_COUNT_RANGE("시도할 횟수 범위가 잘못되었습니다."),
    CAR_NAME_IS_BLANK("자동차 이름은 빈 문자열이거나 공백일 수 없습니다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름 길이가 잘못되었습니다."),
    INVALID_CAR_COUNT("자동차 개수가 너무 많습니다."),
    DUPLICATE_CAR_NAME("중복된 자동차 이름이 있습니다."),
    INVALID_RACING_COUNT_TYPE("시도할 횟수는 정수로 입력해야 합니다.");
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
