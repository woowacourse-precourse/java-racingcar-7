package racingcar;

public enum ExceptionMessage {
    NULL_CAR_NAME("자동차명은 null이 될 수 없습니다. %d자 이상의 문자를 입력해주세요."),
    BLANK_CAR_NAME("자동차명은 공백이 될 수 없습니다."),
    INVALID_LENGTH_RANGE_CAR_NAME("자동차명은 %d자 이상 %d자 이하로 입력해주세요: %s"),
    INVALID_TYPE_ROUND_COUNT("시도 횟수는 숫자로 입력해주세요."),
    INVALID_RANGE_ROUND_COUNT("시도 횟수는 %d 이상의 정수로 입력해주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
