package racingcar.enums;

public enum Exceptions {
    INVALID_INPUT_BLANK("입력 값은 비어 있지 않아야합니다."),
    INVALID_INPUT_DELIMITER("유효한 구분자"+StringPattern.CAR_NAME_DELIMITER +"를 사용해야 합니다."),
    INVALID_INPUT_WHITESPACE("입력에 띄어쓰기는 포함할 수 없습니다."),
    INVALID_INPUT_END("구분자는 입력 마지막에 올 수 없습니다."),
    INVALID_CAR_NAME_EMPTY("차 이름은 하나 이상의 문자를 포함해야 합니다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름은 " +Constraints.MAX_CAR_NAME_LENGTH+"이하만 가능합니다."),
    INVALID_CAR_NAME_DUPLICATION("차 이름은 중복되어 입력될 수 없습니다."),
    INVALID_TURN_NUMERIC("시도할 횟수는 양의 정수이어야 합니다.");

    private String message;

    Exceptions(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
