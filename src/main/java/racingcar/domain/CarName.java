package racingcar.domain;

import racingcar.constant.Rule;
import racingcar.util.validator.StringValidator;

public class CarName {

    private final String value;

    private CarName(final String value) {
        this.value = value;
    }

    public static CarName of(final String value, final StringValidator stringValidator) {
        stringValidator.validateFormat(value);
        stringValidator.validateLength(value, Rule.CAR_NAME_LENGTH_MAX);
        return new CarName(value);
    }

    public String getValue() {
        return this.value;
    }
}
