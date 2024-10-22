package racingcar.global.util;

public enum ErrorMessage {
    INVALID_NAME_FORMAT("[ERROR] 이름은 영문, 숫자, 한글 8글자만 입력해주세요"),

    ;

    ErrorMessage(String message) {
        this.message = message;
    }

    String message;

    public String getMessage() {
        return message;
    }
}
