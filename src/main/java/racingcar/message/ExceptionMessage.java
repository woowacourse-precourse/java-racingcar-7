package racingcar.message;

public enum ExceptionMessage {

    EMPTY_NAME_EXCEPTION("빈 문자열만 입력하면 안됩니다."),
    NEGATIVE_ATTEMPT_EXCEPTION("시도 횟수는 양수여야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
