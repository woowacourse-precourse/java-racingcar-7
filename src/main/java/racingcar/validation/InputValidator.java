package racingcar.validation;

import racingcar.constants.ErrorMessages;
import racingcar.constants.ValidationConstants;

import java.util.List;

public class InputValidator {
    public static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            validateEmptyOrBlank(name);
            validateNameContainsBlank(name);
            validateNameLength(name);
        }
    }

    private static void validateEmptyOrBlank(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_EMPTY_CAR_NAME);
        }
    }

    private static void validateNameContainsBlank(String name) {
        if (name.matches(".*\\s.*")) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_CAR_NAME_CONTAINS_BLANK);
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > ValidationConstants.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_CAR_NAME_TOO_LONG);
        }
    }

    public static int validateMoveCount(String moveCountInput) {
        try {
            int moveCount = Integer.parseInt(moveCountInput);
            if (moveCount < ValidationConstants.MIN_MOVE_COUNT) {
                throw new IllegalArgumentException(ErrorMessages.ERROR_MOVE_COUNT_NEGATIVE);
            }
            return moveCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_MOVE_COUNT_NOT_NUMBER);
        }
    }
}
