package racingcar.constant;

public enum ErrorMessage {
    NO_INPUT("입력값을 넣어 경주를 시작해주세요."),
    EMPTY_NAME("이름이 0자에요."),
    INVALID_CAR_NAME("이름은 영어와 한글만 가능해요."),
    TOO_LONG_CAR_NAME("이름의 길이는 5글자 이하만 가능해요."),
    INVALID_RACE_TIME("시도할 횟수가 가능한 범위를 넘어가거나 올바르지 않아요."),
    NEGATIVE_RACE_TIME("시도할 횟수는 0과 양의 정수만 가능해요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
