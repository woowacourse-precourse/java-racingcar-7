package racingcar.front.exception.message;

public enum ExceptionMessage {
    INVALID_CAR_NAME("자동차 이름은 1글자 이상, 5글자 이하여야 하며 쉼표와 공백은 허용되지 않습니다."),
    INVALID_PLAY_COUNT("시도 횟수는 양의 정수값만 입력 가능합니다."),
    DUPLICATED_CAR_NAME("중복된 차 이름은 허용되지 않습니다.");
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
