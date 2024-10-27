package racingcar.validation;

public interface Validator {
    Class<?> supportsType();
    void validate(Object target);
}
