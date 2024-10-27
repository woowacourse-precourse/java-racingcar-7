package racingcar.utils;

public class Validator {
    public static final Integer NAME_LENGTH_LIMIT = 5;
    public static final String NAME_LENGTH_OVER_LIMIT_MESSAGE = "이름은 5자 이하이어야 합니다.";

    private Validator() {
    }

    public static void checkNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(NAME_LENGTH_OVER_LIMIT_MESSAGE);
        }
    }
}
