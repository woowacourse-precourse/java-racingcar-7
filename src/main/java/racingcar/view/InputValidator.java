package racingcar.view;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String ERROR_MESSAGE_EMPTY_INPUT = "입력값은 공백일 수 없습니다.";
    private static final String ERROR_MESSAGE_TRAILING_COMMA = "입력값의 마지막에 콤마(,)가 올 수 없습니다.";
    private static final Pattern TRAILING_COMMA_PATTERN = Pattern.compile(".*,$");

    public static void validateCarNamesInput(String input) {
        checkEmptyInput(input);
        checkTrailingComma(input);
    }

    public static void validateAttemptCountInput(String input) {
        checkEmptyInput(input);
    }

    private static void checkEmptyInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY_INPUT);
        }
    }

    private static void checkTrailingComma(String input) {
        if (TRAILING_COMMA_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_TRAILING_COMMA);
        }
    }
}
