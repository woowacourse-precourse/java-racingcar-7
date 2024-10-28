package racingcar.enums;

public enum Exceptions {
    INVALID_CAR_NAME_LENGTH("자동차의 이름은 5자 이하만 가능합니다."),
    INVALID_END_WITH_COMMA("입력의 마지막은 콤마(,)로 끝날 수 없습니다."),
    INVALID_NAME_DELIMITER_FORMAT("자동차 이름들은 콤마로 구분해야합니다."),
    INVALID_INPUT_EMPTY("빈 값은 입력할 수 없습니다."),
    INVALID_INPUT_WHITESPACE("입력에 공백이 포함될 수 없습니다."),
    DUPLICATE_CAR_NAME("자동차 이름에 중복이 존재합니다."),
    EMPTY_CAR_NAME("자동차의 이름은 빈 값일 수 없습니다."),
    INVALID_TRY_COUNT("올바른 양의 정수만 입력할 수 있습니다.");
    private final String message;

    Exceptions(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
