package racingcar.vo;

public enum ExceptionMessage {
    INVALID_NEGATIVE_NUMBER("횟수는 1보다 작을 수 없습니다."),
    INVALID_NOT_NUMBER("숫자 외 값이 입력될 수 없습니다."),
    INVALID_NOT_ALLOWED_NAME("이름에 특수문자는 허용되지 않습니다."),
    INVALID_NOT_NAME("입력값이 올바르지 않습니다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름 길이는 5를 넘을 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
