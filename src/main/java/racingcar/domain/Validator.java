package racingcar.domain;

public class Validator {
    public static final String INVALID_INPUT_ERROR = "값이 입력되지 않았습니다.";
    public static final String INVALID_NAME_LENGTH_ERROR = "이름은 1~5자 사이여야 합니다.";
    public static final String EMPTY_NAME_ERROR = "이름이 비어있을 수 없습니다.";

    public static void validateInput(String input) {
        if(input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    public static void validateName(String name) {
        validateNameNotEmpty(name);
        validateNameLength(name);
    }

    private static void validateNameNotEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR);
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_ERROR);
        }
    }
}
