package racingcar.domain;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자 이하 입니다.";
    private final String name;

    private Name(final String name) {
        validateLength(name);
        this.name = name.trim();
    }

    private static void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public static Name create(final String name) {
        return new Name(name);
    }

    public String name() {
        return this.name;
    }
}
