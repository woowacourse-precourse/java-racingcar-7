package racingcar.exception;

public enum ErrorCode {
    // Invalid Argument Error
    INVALID_NAME_LENGTH("이름의 길이는 5자까지 가능합니다.");
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
