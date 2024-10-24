package racingcar.domain;

import racingcar.constant.Rule;
import racingcar.util.RacingCarValidator;

public class Count<T extends Number> {

    private final T value;

    private Count(final T value) {
        this.value = value;
    }

    public static Count<Integer> of(final int value) {
        RacingCarValidator.validateCountValueRange(value, Rule.COUNT_INTEGER_MAX);
        return new Count<>(value);
    }

    public T getValue() {
        return this.value;
    }
}
