package racingcar.view;

import static racingcar.error.ErrorMessageConstants.EMPTY_INPUT_ERROR;
import static racingcar.error.ErrorMessageConstants.NON_NUMERIC_INPUT_ERROR;
import static racingcar.error.ErrorMessageConstants.NON_POSITIVE_INTEGER_ERROR;

public class InputValidator {

    public static void validateCarNames(String input) {
        validateBlanckInput(input);
    }

    public static void validateTotalRounds(String input) {
        validateBlanckInput(input);
        validateNumericInput(input);
        validatePositiveInteger(input);
    }

    private static void validateBlanckInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }
    }

    private static void validateNumericInput(String input) {
        try {
            int rounds = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT_ERROR);
        }
    }

    private static void validatePositiveInteger(String input) {
        int rounds = Integer.parseInt(input);
        if (rounds <= 0) {
            throw new IllegalArgumentException(NON_POSITIVE_INTEGER_ERROR);
        }
    }

}