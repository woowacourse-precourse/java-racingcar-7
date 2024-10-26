package racingcar.validation;

import static racingcar.validation.ErrorMessage.INVALID_INPUT_NUMBER;
import static racingcar.validation.ErrorMessage.MINIMUM_RACING_TIME;
import static racingcar.validation.ErrorMessage.USER_INPUT_NOT_NULL;

public class Validator {

    private static final String CHECK_NUMBER_REGEX = "\\d+";
    private static final int MINIMUM_RACING_VALUE = 0;

    public void verifyRepeatCount(String userInput) {
        if (!userInput.matches(CHECK_NUMBER_REGEX)) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER.getMessage());
        }
        if (Integer.parseInt(userInput) == MINIMUM_RACING_VALUE) {
            throw new IllegalArgumentException(MINIMUM_RACING_TIME.getMessage());
        }
    }

    public void verifyUserInput(String userInput) {
        if (userInput.isBlank() || userInput == null) {
            throw new IllegalArgumentException(USER_INPUT_NOT_NULL.getMessage());
        }
    }

}
