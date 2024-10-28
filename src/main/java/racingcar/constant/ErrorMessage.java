package racingcar.constant;

public enum ErrorMessage {

    CARNAME_BLANK_EXCEPTION("자동차 이름은 공백이면 안됩니다."),
    CARNAME_LENGTH_EXCEPTION("자동차는 5자 이하만 입력이 가능합니다. 입력 받은 자동차 이름: "),
    ATTEMPTS_FORMAT_EXCEPTION("시도 횟수 입려 형식이 잘못됐습니다. 입력 받은 횟수: "),
    DUPLICATE_CARNAME_EXCEPTION("중복된 자동차 이름을 입력할 수 없습니다. 중복된 자동차 이름 :")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
