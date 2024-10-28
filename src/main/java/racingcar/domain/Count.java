package racingcar.domain;

import racingcar.constant.Rule;
import racingcar.util.validator.NumberValidator;

public class Count {

    private final int value;

    private Count(final int value) {
        this.value = value;
    }

    public static Count of(final String input, final NumberValidator<Integer> numberValidator) {
        numberValidator.validateFormat(input);
        final int value = Integer.parseInt(input);
        numberValidator.validateRange(value, Rule.COUNT_MAX);
        return new Count(value);
    }

    public int getValue() {
        return this.value;
    }
}
