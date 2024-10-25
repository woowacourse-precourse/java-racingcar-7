package racingcar.domain;

import racingcar.utils.validation.CarNameValidation;

public class Name {

    private final String name;

    private Name(String name) {
        CarNameValidation.validate(name);
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public static Name from(final String name) {
        return new Name(name);
    }
}
