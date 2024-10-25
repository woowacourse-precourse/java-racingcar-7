package racingcar.constant;

public enum ErrorMessage {

    CARNAME_BLANK_EXCEPTION("자동차 이름은 공백이면 안됩니다."),
    CARNAME_LENGTH_EXCEPTION("자동차는 5자 이하만 입력이 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
