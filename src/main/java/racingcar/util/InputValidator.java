package racingcar.util;

import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d*");

    private InputValidator() {

    }

    public static void validateInputCountFormat(final String input) {
        if (isNotNumber(input)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputCarNameFormat(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNotNumber(final String input) {
        return !NUMBER_PATTERN.matcher(input).matches();
    }
}
