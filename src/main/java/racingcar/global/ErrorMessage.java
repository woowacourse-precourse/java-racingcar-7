package racingcar.global;

public enum ErrorMessage {
    // 도메인관련
    DUPLICATE_CAR_NAME("자동차 이름은 중복되어서는 안됩니다."),

    // 입력관련,
    NO_LINES_FOUND("입력이 없습니다"),
    BLANK_CAR_NAME("공백이 입력되어선 안됩니다."),
    CAR_NAME_LENGTH_EXCEEDED("자동차 이름은 5글자 이하로 이루어져야 합니다."),
    POSITIVE_INTEGER_ALLOWED("시도 횟수는 0 이상의 정수로만 입력되어야 합니다."),
    NUMBER_FORMAT_REQUIRED("숫자 형식으로 입력해야 합니다."),

    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
