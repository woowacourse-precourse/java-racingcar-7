package racingcar.service;

import static racingcar.exception.ExceptionMessage.INVALID_INPUT_NUMBER;
import static racingcar.exception.ExceptionMessage.MINIMUM_RACING_TIME;
import static racingcar.exception.ExceptionMessage.USER_INPUT_NOT_NULL;


public class RacingService {

    private static final String CHECK_NUMBER_REGEX = "\\d+";


    public String getValidatedStringInput(String userStringInput) {
        verifyUserInput(userStringInput);
        return userStringInput;
    }

    public int getValidateIntegerInput(String userIntegerInput) {
        verifyRepeatCount(userIntegerInput);
        return Integer.parseInt(userIntegerInput);
    }

    private void verifyRepeatCount(String userInput) {
        if (!userInput.matches(CHECK_NUMBER_REGEX)) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER.getMessage());
        }
        if (Integer.parseInt(userInput) == 0) {
            throw new IllegalArgumentException(MINIMUM_RACING_TIME.getMessage());
        }
    }

    private void verifyUserInput(String userInput) {
        if (userInput.isBlank() || userInput == null) {
            throw new IllegalArgumentException(USER_INPUT_NOT_NULL.getMessage());
        }
    }

}
