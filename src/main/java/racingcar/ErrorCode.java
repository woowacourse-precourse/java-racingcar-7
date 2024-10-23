package racingcar;

public enum ErrorCode {
    CONSECUTIVE_COMMA("입력에 쉼표가 연속적으로 입력되었습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
