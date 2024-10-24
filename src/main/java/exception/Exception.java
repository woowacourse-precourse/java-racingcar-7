package exception;

public enum Exception {
    UNDER_FIVE_LETTERS("이름의 길이는 5글자 이하여야합니다."),
    DUPLICATE_PARTICIPANTS("중복된 참가자가 존재합니다."),
    SINGLE_PARTICIPANTS("혼자서는 경기를 진행할 수 없습니다."),
    POSITIVE_TIMES("시도 횟수는 양의 정수만 입력 가능합니다."),
    NUMERIC_TIMES("시도 횟수는 숫자만 입력 가능합니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
