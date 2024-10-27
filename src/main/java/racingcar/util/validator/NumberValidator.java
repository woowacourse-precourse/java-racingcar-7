package racingcar.util.validator;

public interface NumberValidator<T extends Number> {

    void validateFormat(final String value);
    void validateRange(final T value, final T maxValue);
}
