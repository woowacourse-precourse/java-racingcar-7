package racingcar.application.util.validator;

import racingcar.application.util.io.vo.Input;

import java.util.Arrays;

public final class InputValidator {

    private static final String COMMA = ",";
    private static final String REGEX_NAME_INPUT = "^[a-zA-Z가-힣0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|.<>\\/?]+";

    private InputValidator() {}

    public static void validateNamesInput(Input input) {
        validateCommaAtStartOrEnd(input);
        validateEachNameFormatAvailable(input);
        validateNameDuplication(input);
    }

    private static void validateNameDuplication(Input input) {
        long nameCount = Arrays.stream(input.value().split(COMMA))
                .count();
        long distinctNameCount = Arrays.stream(input.value().split(COMMA))
                .distinct()
                .count();
        if (distinctNameCount != nameCount) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateEachNameFormatAvailable(Input input) {
        for (String nameInput : input.value().split(COMMA)) {
            if (!nameInput.trim().matches(REGEX_NAME_INPUT)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateCommaAtStartOrEnd(Input input) {
        if (input.value().startsWith(COMMA) || input.value().endsWith(COMMA)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateTrialInput(Input input) {
        try {
            Long.parseLong(input.value());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

}
