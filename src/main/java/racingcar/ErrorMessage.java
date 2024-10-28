package racingcar;

public enum ErrorMessage {

    REPETITION_COUNT_NOT_A_NUMBER("시도 횟수는 숫자를 입력해주세요."),
    REPETITION_COUNT_IS_BLANK("시도 횟수를 입력해주세요."),
    REPETITION_COUNT_NOT_NEGATIVE("시도 횟수는 양수로 입력해주세요."),
    CAR_NAME_NOT_CONTAINS_EDGE_COMMA("자동차 이름 앞뒤에 콤마를 포함할 수 없습니다."),
    CAR_NAME_IS_BLANK("자동차 이름을 입력해주세요."),
    CAR_NAMES_NOT_CONTAINS_COMMA("자동차 이름은 구분자로 콤마를 포함해야 합니다."),
    CAR_NAMES_NOT_SPECIAL_CHAR("자동차 이름은 알파벳과 숫자만 가능합니다."),
    CAR_NAME_LENGTH_OVER("자동차 이름은 5글자를 넘을 수 없습니다."),
    CAR_COUNT_NOT_ENOUGH("자동차를 2개 이상 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
