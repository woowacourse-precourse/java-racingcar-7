package racingcar.view;

import static racingcar.utils.ExceptionConstants.EMPTY_INPUT;

public class InputValidator {
    public static void validateUserInputNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getErrorMessage());
        }
    }
}
