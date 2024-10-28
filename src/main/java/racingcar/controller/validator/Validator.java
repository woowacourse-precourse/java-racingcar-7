package racingcar.controller.validator;

import static racingcar.exception.ErrorBase.INPUT_IS_EMPTY;

import org.junit.platform.commons.util.StringUtils;

public abstract class Validator<T> {
    public T validate(String input) {
        validateBlankInput(input);
        T parsedInput = parseInput(input);
        validateRange(parsedInput);
        return parsedInput;
    }

    protected void validateBlankInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY.getMessage());
        }
    }

    protected abstract T parseInput(String input);

    protected abstract void validateRange(T input);
}
