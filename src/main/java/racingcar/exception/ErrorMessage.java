package racingcar.exception;

public enum ErrorMessage {
    EMPTY_INPUT("입력값이 공백입니다"),
    EMPTY_CAR_NAME("자동차 이름이 공백입니다"),
    TOO_LONG_NAME("이름이 다섯글자를 초과했습니다"),
    DUPLICATION("자동차 이름이 중복되었습니다"),
    NOT_NUMBER("입력값이 숫자가 아닙니다"),
    NOT_INT("입력값이 정수가 아닙니다"),
    NOT_POSITIVE_INT("입력값이 양의 정수가 아닙니다"),
    SPACES_NOT_ALLOWED("자동차 이름에 공백이 포함되면 안됩니다");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
