package racingcar.validate;

import racingcar.validate.enums.ValidateMessages;

public class InputNumberValidation {

    public InputNumberValidation() {
    }

    public void validateInputNumber(String inputNumber) {
        validateNumberIfNullOrEmpty(inputNumber);
        validateIfInputCanCovertToInt(inputNumber);
        validateNumberIfNegative(inputNumber);
        validateNumberIfContainsNewLine(inputNumber);
        validateNumberIfWhiteSpaceExist(inputNumber);
        validateIfNumberStartsWithZero(inputNumber);
    }

    public void validateNumberIfNullOrEmpty(String inputNumber) {
        if (inputNumber == null || inputNumber.isEmpty()) {
            throw new IllegalArgumentException(ValidateMessages.NUMBER_CANNOT_BE_NULL_OR_EMPTY.getValidateMessage());
        }
    }

    public void validateNumberIfNegative(String inputNumber) {
        if (Integer.parseInt(inputNumber) < 0) {
            throw new IllegalArgumentException(ValidateMessages.NUMBER_CANNOT_BE_NEGATIVE.getValidateMessage());
        }
    }

    public void validateIfInputCanCovertToInt(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidateMessages.NUMBER_SHOULD_BE_INTEGER.getValidateMessage());
        }
    }

    public void validateNumberIfContainsNewLine(String inputNumber) {
        if (inputNumber.contains("\n")) {
            throw new IllegalArgumentException(
                    ValidateMessages.NUMBER_SHOULD_NOT_CONTAIN_NEW_LINE.getValidateMessage());
        }
    }

    public void validateNumberIfWhiteSpaceExist(String inputNumber) {
        if (inputNumber.contains(" ")) {
            throw new IllegalArgumentException(ValidateMessages.NUMBER_SHOULD_NOT_CONTAIN_EMPTY.getValidateMessage());
        }
    }

    public void validateIfNumberStartsWithZero(String inputNumber) {
        if (inputNumber.length() > 1 && inputNumber.startsWith("0")) {
            throw new IllegalArgumentException(ValidateMessages.NUMBER_CANNOT_START_WITH_ZERO.getValidateMessage());
        }
    }
}
