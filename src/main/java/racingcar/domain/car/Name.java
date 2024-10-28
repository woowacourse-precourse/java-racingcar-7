package racingcar.domain.car;

import racingcar.domain.validator.CarNameValidator;

public class Name {
    private final String value;
    private final CarNameValidator validator;

    public Name(String value) {
        this.validator = new CarNameValidator();
        this.validator.validate(value);
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}