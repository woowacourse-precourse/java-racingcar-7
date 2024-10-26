package racingcar.exception;

public enum ExceptionMessage {
    OVER_MAX_CAR_NAME("자동차의 이름은 최대 5자 입니다."),
    INVALID_INPUT_NUMBER("유효하지 않은 입력입니다. 정수를 입력해주세요."),
    USER_INPUT_NOT_NULL("입력은 공백일 수 없습니다."),
    MINIMUM_RACING_TIME("경기는 한 번 이상 진행되어야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
