package exception;

public enum ErrorCode {
    EMPTY_CAR_NAME("빈 문자열은 차 이름이 될 수 없습니다."),
    ;

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
