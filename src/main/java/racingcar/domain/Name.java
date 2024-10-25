package racingcar.domain;

import racingcar.utils.validation.CarNameValidation;

public class Name {

    private final String name;

    public Name(final String name) {
        CarNameValidation.validate(name);
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
