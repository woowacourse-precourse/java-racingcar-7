package racingcar.utils.message;

/**
 * 예외 메시지 관련 클래스
 */
public enum ErrorMessage {

    EMPTY_INPUT("문자열이 공백입니다. 숫자를 입력하세요."),
    NOT_INT("숫자가 아니거나 int 범위(2의 31승 - 1)를 벗어납니다."),
    ZERO("시도할 횟수는 1 이상이어야 합니다."),
    INVALID_NAME_FORMAT("올바른 자동차 이름 형식이 아닙니다. " +
            "이름에 허용되는 문자는 알파벳, 한글, 아라비아 숫자입니다."),
    IN_SPACE("이름은 빈 칸(띄어쓰기) 없이 입력하세요."),
    DUPLICATE_NAMES("차 이름은 중복되면 안됩니다.");

    private final String message;

    public static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return EXCEPTION_MESSAGE_PREFIX + message;
    }

}
