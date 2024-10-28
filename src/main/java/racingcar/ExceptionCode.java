package racingcar;

public enum ExceptionCode {
    NAME_LENGTH_EXCEEDED("5자 이하만 가능합니다.");

    private final String message;

    ExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
