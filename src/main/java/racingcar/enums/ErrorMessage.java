package racingcar.enums;

public enum ErrorMessage {
    ERR_INVALID_CAR_LIST("자동차 이름 입력이 잘못되었습니다."),
    ERR_CAR_NAME_ISNULL("자동차 이름은 비어있을 수 없습니다."),
    ERR_INVALID_CAR_NAME_LENGTH("자동차 이름은 5글자 이하입니다."),
    ERR_CAR_NAME_CONTAIN_INVALID_CHARACTER("유효하지 않은 문자가 포함되어있습니다."),
    ERR_NOT_ALLOW_DUPLICATED_NAME("자동차 이름은 중복될 수 없습니다."),
    ERR_NOT_ALLOW_NUMBER_INPUT("빈 입력은 입력할 수 없습니다."),
    ERR_INPUT_NUMBER_IS_NOT_VALID("숫자 입력이 숫자형식이 아닙니다."),
    ERR_NUMBER_MUST_BE_POSITIVE_NUMBER("숫자 입력은 양의 정수이어야 합니다."),
    ERR_NUMBER_CANT_OVER_MAX_LIMIT("숫자 입력은 1000이하만 가능합니다.");

    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
