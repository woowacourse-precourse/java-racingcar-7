package racingcar.domain;

import racingcar.util.NumberValidator;

public class Count<T extends Number>{

    private final T value;

    private Count(final T value) {
        this.value = value;
    }

    public static Count<Integer> of(final String input, final NumberValidator<Integer> numberValidator) {
        numberValidator.validateFormat(input);
        final int value = Integer.parseInt(input);
        numberValidator.validateRange(value, Integer.MAX_VALUE);
        return new Count<>(value);
    }

    public T getValue() {
        return this.value;
    }
}
