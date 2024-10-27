package racingcar.validate;

import java.util.HashSet;
import java.util.List;
import racingcar.validate.enums.ValidateMessages;

public class CarNameValidation {
    public static void validateName(String name) {
        validateIfCarNameIsNUllOrEmpty(name);
        validateIfCarNameHasNewline(name);
        validateIfCarNameLengthWithinFive(name);
        validateIfCarNameContainsWhiteSpace(name);
    }

    public static void validateIfCarNameIsNUllOrEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ValidateMessages.CAR_CANNOT_BE_NULL_OR_EMPTY.getValidateMessage());
        }
    }

    public static void validateIfCarNameHasNewline(String name) {
        if (name.contains("\n")) {
            throw new IllegalArgumentException(ValidateMessages.CAR_NAME_CANNOT_CONTAIN_NEWLINE.getValidateMessage());
        }
    }

    public static void validateIfCarNameLengthWithinFive(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(
                    ValidateMessages.CAR_NAME_LENGTH_CANNOT_BE_OVER_FIVE.getValidateMessage());
        }
    }

    public static void validateIfCarNameContainsWhiteSpace(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(
                    ValidateMessages.CAR_NAME_SHOULD_NOT_CONTAIN_WHITESPACE.getValidateMessage());
        }
    }

    public static void validateIfCarNameDuplicated(List<String> carNames) {
        if (carNames.size() != new HashSet<>(carNames).size()) {
            throw new IllegalArgumentException(ValidateMessages.CAR_NAME_CANNOT_BE_DUPLICATED.getValidateMessage());
        }
    }
}
