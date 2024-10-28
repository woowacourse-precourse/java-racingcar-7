package constants;

public enum ExceptionConstants {

    STRING_LEN_OVER("문자열 길이 초과"),
    NOT_INTEGER("정수가 아님"),
    IS_NULL("빈 문자열");

    private final String msg;

    ExceptionConstants(String message) {
        this.msg = message;
    }

    public String getMessage() {
        return msg;
    }
}
