package racingcar.domain.car;

import static racingcar.constant.ExceptionMessage.CAR_NAME_LENGTH_MUST_BE_LESS;

public class Name {

    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    public String get() {
        return name;
    }

    private void validateName(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_MUST_BE_LESS.getMessage(MAXIMUM_NAME_LENGTH));
        }
    }
}
