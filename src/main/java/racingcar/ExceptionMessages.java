package racingcar;

public enum ExceptionMessages {
    NAME_TOO_LONG("자동차 이름은 5자 이하만 가능합니다."),
    ;

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
