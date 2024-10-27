package racingcar.global.enums;

public enum ErrorMessage {
    WRONG_INPUT("숫자만 입력 가능합니다."),
    ALLOWED_ONLY_POSITIVE("양수만 입력 가능합니다."),
    INVALID_NAME_LENGTH("이름은 5자 이하만 가능합니다."),
    NOT_ALLOWED_EMPTY_SPACE("빈칸은 허용되지 않습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
