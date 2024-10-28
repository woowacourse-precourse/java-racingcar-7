package racingcar.exception;

public enum ErrorMessage {
    EMPTY_INPUT("입력이 비어 있습니다."),
    LENGTH_OVER("이름이 최대 길이인 5자를 넘었습니다."),
    INVALID_FORMAT("입력 가능한 이름 양식인 알파벳, 숫자 타입이 아닙니다."),

    // ------
    NOT_NUMERIC("숫자만 포함해야 합니다."),
    NEGATIVE_OR_ZERO("양의 정수여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
