package racingcar.validate;

import racingcar.validate.enums.ValidateMessages;

public class InputNumberValidation {
    public static int validateInputNumber(String inputNumber) {
        int numberOfAttempts = 0;
        validateNumberIfNullOrEmpty(inputNumber);
        validateIfInputCanCovertToInt(inputNumber);
        validateNumberIfContainsNewLine(inputNumber);
        return numberOfAttempts;
    }

    public static void validateNumberIfNullOrEmpty(String inputNumber) {
        if (inputNumber == null || inputNumber.isEmpty()) {
            throw new IllegalArgumentException(ValidateMessages.NUMBER_CANNOT_BE_NULL_OR_EMPTY.getValidateMessage());
        }
    }

    public static void validateIfInputCanCovertToInt(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidateMessages.NUMBER_SHOULD_BE_INTEGER.getValidateMessage());
        }
    }

    public static void validateNumberIfContainsNewLine(String inputNumber) {
        if (inputNumber.contains("\n")) {
            throw new IllegalArgumentException(
                    ValidateMessages.NUMBER_SHOULD_NOT_CONTAIN_NEW_LINE.getValidateMessage());
        }
    }
}
