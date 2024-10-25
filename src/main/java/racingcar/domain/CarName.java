package racingcar.domain;

import racingcar.util.StringValidator;

public class CarName {

    private static final int MAX_LENGTH = 5;
    private final String value;

    private CarName(final String value) {
        this.value = value;
    }

    public static CarName of(final String value, final StringValidator stringValidator) {
        stringValidator.validateFormat(value);
        stringValidator.validateLength(value, MAX_LENGTH);
        return new CarName(value);
    }

    public String getValue() {
        return this.value;
    }
}
