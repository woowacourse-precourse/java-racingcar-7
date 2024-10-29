package racingcar.util;


public enum ErrorMessage {
    NULL_OR_EMPTY_INPUT("널이거나 공백입니다."),
    ONLY_DELIMITER_STRING("구분자로만 이루어진 문자열입니다."),
    BLANK_NAME("이름은 빈 문자열이 될 수 없습니다."),
    NAME_TOO_LONG("이름의 길이가 5글자 이상입니다."),
    NEGATIVE_NUMBER("음수입니다."),
    ZERO_OR_OVERFLOW("입력값이 0이거나 오버플로우가 발생했습니다."),
    INVALID_FORMAT("입력값이 소수나 문자입니다."),
    TIME_COMPLEXCITY("연산 횟수가 100만 이상입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}