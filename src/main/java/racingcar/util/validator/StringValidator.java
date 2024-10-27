package racingcar.util.validator;

public interface StringValidator {

    void validateFormat(final String value);
    void validateLength(final String value, final int maxLength);
}
