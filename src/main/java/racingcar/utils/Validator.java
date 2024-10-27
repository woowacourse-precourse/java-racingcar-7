package racingcar.utils;

public class Validator {
    public static final Integer NAME_LENGTH_LIMIT = 5;
    public static final String NAME_LENGTH_OVER_LIMIT_MESSAGE = "이름은 5자 이하이어야 합니다.";
    public static final String INPUT_NAME_MESSAGE = "이름을 입력해야 합니다.";

    private Validator() {
    }

    public static void validateNameLengthLimit(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(NAME_LENGTH_OVER_LIMIT_MESSAGE);
        }
    }

    public static void validateNameIsEmpty(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException(INPUT_NAME_MESSAGE);
        }
    }
}
