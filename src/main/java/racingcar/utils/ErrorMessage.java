package racingcar.utils;

public enum ErrorMessage {
    COUNT_NOT_NUMBER("숫자만 입력 가능합니다."),
    NAME_OVER_LIMIT("이름은 한 명당 5자 이하만 입력 가능합니다."),
    EMPTY_NAME("이름은 공백이 될 수 없습니다."),
    DUPLICATE_NAME("이름은 중복될 수 없습니다.");

    private final String MESSAGE;

    ErrorMessage(String message) {
        this.MESSAGE = message;
    }

    public String getMessage() {
        return MESSAGE;
    }
}
