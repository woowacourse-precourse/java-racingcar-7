package racingcar.constant;

public enum ErrorMessage {

    CAR_NAME_CANNOT_BE_NULL_OR_EMPTY("자동차 이름을 입력해주세요."),
    CAR_NAME_MUST_BE_SEPARATED_BY_COMMAS("자동차 이름을 쉼표로 구분해서 입력해주세요."),
    CAR_NAME_CANNOT_END_WITH_COMMA("입력을 쉼표로 끝냈습니다."),
    CAR_NAME_LENGTH_INVALID("자동차 이름은 1글자 이상 5글자 이하로 입력해주세요."),
    DUPLICATE_CAR_NAME_FOUND("중복된 자동차 이름이 있습니다."),
    ATTEMPT_COUNT_CANNOT_BE_NULL_OR_EMPTY("양의 정수를 입력해주세요."),
    ATTEMPT_COUNT_IS_NOT_AN_INTEGER("입력 값이 정수가 아닙니다."),
    ATTEMPT_COUNT_IS_NOT_POSITIVE_INTEGER("입력 값이 양의 정수가 아닙니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
