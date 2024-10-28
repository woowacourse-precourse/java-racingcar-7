package racingcar.validator;

import static racingcar.validator.ErrorMessage.EMPTY_OR_BLANK_INPUT_ERROR;
import static racingcar.validator.ErrorMessage.NON_NUMERIC_INPUT_ERROR;

import java.util.regex.Pattern;

public class InputViewValidator {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]+$");

    public void validateNotEmptyAndBlank(String input) {
        if (input.isEmpty() || input.trim().isBlank()) {
            throw new IllegalArgumentException(EMPTY_OR_BLANK_INPUT_ERROR.getMessage());
        }
    }

    public void validateNumeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT_ERROR.getMessage());
        }
    }
}
