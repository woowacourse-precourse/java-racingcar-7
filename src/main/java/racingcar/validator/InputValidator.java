package racingcar.validator;

import racingcar.message.ErrorMessage;

public class InputValidator {

    public static void validateEmpty(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.STRING_IS_EMPTY_MESSAGE);
        }
    }

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_NUMBER_MESSAGE);
        }
    }
}
