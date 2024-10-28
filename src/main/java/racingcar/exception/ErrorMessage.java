package racingcar.exception;

public enum ErrorMessage {
    EMPTY_INPUT("입력값이 비어 있습니다."),
    EXCEED_NAME_LENGTH("이름의 길이가 5자를 초과하였습니다."),
    INVALID_NUMBER_FORMAT("잘못된 숫자 형식입니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
