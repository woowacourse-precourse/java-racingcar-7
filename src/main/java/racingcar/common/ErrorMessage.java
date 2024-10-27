package racingcar.common;

public enum ErrorMessage {
    TOO_LONG_CAR_NAME("길이가 5 초과인 자동차 이름이 있습니다."),
    NO_CAR_NAME("자동차 이름이 입력되지 않았습니다."),
    TOO_MANY_CAR_NAME("자동차 이름이 100개 넘게 입력되었습니다."),
    THERE_IS_NEW_LINE_CHARACTER("자동차 이름에는 개행문자가 포함될 수 없습니다."),
    RACE_COUNT_SIZE("경주횟수는 100 이하 양의 정수여야 합니다."),
    PARSE_ERROR_STRING_TO_INT("경주 횟수를 INT로 변환할 수 없습니다."),
    INPUT_MUST_NOT_END_WITH_COMMA("자동차 이름 입력이 쉼표로 끝나면 안됩니다."),
    CAR_NAME_MUST_NOT_BE_EMPTY("자동차 이름이 공백일 수 없습니다."),
    CAR_NAME_MUST_NOT_CONTAIN_BLANK("자동차 이름에 공백이 포함될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
