package racingcar.view;

import static racingcar.utils.ExceptionConstants.EMPTY_INPUT;
import static racingcar.utils.ExceptionConstants.INVALID_ROUND_NUMBER;

public class InputValidator {
    public static void validateUserInputNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getErrorMessage());
        }
    }

    public static void validateUserInputIsNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ROUND_NUMBER.getErrorMessage());
        }
    }
}
