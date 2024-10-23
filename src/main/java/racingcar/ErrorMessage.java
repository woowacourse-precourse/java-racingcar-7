package racingcar;

public enum ErrorMessage {
    // 도메인관련
    DUPLICATE_CAR_NAME("자동차 이름은 중복되어서는 안된다."),
    INVALID_CHARACTER("숫자를 제외한 문자는 허용되지 않습니다."),
    BLANK_CAR_NAME("자동차 이름은 공백 일 수 없습니다."),

    // 입력관련
    NO_LINES_FOUND("입력이 없습니다"),

    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
