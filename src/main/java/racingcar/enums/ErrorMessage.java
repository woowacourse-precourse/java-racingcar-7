package racingcar.enums;

public enum ErrorMessage {
    BLANK_INPUT_NOT_ALLOWED("자동차 이름은 null, 빈문자열, 공백으로만 이루어진 문자열일 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
