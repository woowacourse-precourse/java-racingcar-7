package exception;

public enum ErrorCode {
    EMPTY_CAR_NAME("빈 문자열은 차 이름이 될 수 없습니다."),
    DUPLICATE_CAR_NAME("중복하는 차 이름이 있습니다."),
    CAR_NAME_LIMIT("차 이름은 5글자를 넘어갈 수 없습니다."),
    ;

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
