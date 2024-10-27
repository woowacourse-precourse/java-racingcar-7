package racingcar.validator;

import racingcar.message.ErrorMessage;

public class InputValidator {

    private final static int NAME_LENGTH = 5;

    public static void validateEmpty(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.STRING_IS_EMPTY_MESSAGE);
        }
    }

    public static void validateCharacter(String input) {
        if (!input.matches("[a-zA-Z,]+")) {
            throw new IllegalArgumentException(ErrorMessage.NON_ALPHA_MESSAGE);
        }
    }

    public static void validateNameLength(String input) {
        if (input.length() > NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_MESSAGE);
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
