package racingcar.message;

public enum ExceptionMessage {

    NULL_INPUT_EXCEPTION_MESSAGE("null 값이 입력되었습니다."),
    EMPTY_NAME_EXCEPTION_MESSAGE("잘못된 이름을 입력하셨습니다. 빈 이름은 사용할 수 없습니다."),
    NAME_LENGTH_OVER_EXCEPTION_MESSAGE("잘못된 이름을 입력하셨습니다. 이름은 5자를 초과하면 안됩니다."),
    INVALID_CHARACTER_EXCEPTION_MESSAGE("잘못된 이름을 입력하셨습니다. 이름은 오직 한글,영어,숫자로만 구성되어야합니다."),
    START_OR_END_WITH_WHITESPACE_EXCEPTION_MESSAGE("잘못된 이름을 입력하셨습니다. 이름 앞뒤에 공백을 사용할 수 없습니다."),
    DUPLICATION_NAME_EXCEPTION_MESSAGE("잘못된 이름을 입력하셨습니다. 중복된 이름을 사용할 수 없습니다. +"
            + "(중복된 이름을 사용하고 싶을 경우 숫자 및 대소문자를 통해 구분해주세요)"),

    INVALID_RANDOM_NUMBER_EXCEPTION_MESSAGE("유효하지 않은 무작위 값이 들어왔습니다. " +
            "(무작위 값은 0이상 9이하의 값이어야 합니다.)");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
