package racingcar.validator;

import java.util.regex.Pattern;

public class InputViewValidator {
    private static final String EMPTY_OR_BLANK_INPUT_ERROR = "입력이 비어있거나 공백일 수 없습니다.";
    private static final String NON_NUMERIC_INPUT_ERROR = "입력값은 숫자여야 합니다.";
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]+$");

    public void validateNotEmptyAndBlank(String input) {
        if (input.isEmpty() || input.trim().isBlank()) {
            throw new IllegalArgumentException(EMPTY_OR_BLANK_INPUT_ERROR);
        }
    }

    public void validateNumeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT_ERROR);
        }
    }
}
