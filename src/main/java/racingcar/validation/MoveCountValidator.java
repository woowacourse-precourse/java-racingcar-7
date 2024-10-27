package racingcar.validation;

import racingcar.constants.ErrorMessageConstants;
import racingcar.constants.ValidationConstants;

public class MoveCountValidator {
    public static void validateMoveCount(String moveCountInput) {
        validateNullOrEmptyMoveCount(moveCountInput);
        validateNumericAndPositive(moveCountInput);
    }

    private static void validateNullOrEmptyMoveCount(String moveCountInput) {
        if (moveCountInput == null || moveCountInput.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessageConstants.ERROR_EMPTY_MOVE_COUNT);
        }
    }

    private static void validateNumericAndPositive(String moveCountInput) {
        try {
            int moveCount = Integer.parseInt(moveCountInput);
            validatePositiveMoveCount(moveCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageConstants.ERROR_MOVE_COUNT_NOT_NUMBER);
        }
    }

    private static void validatePositiveMoveCount(int moveCount) {
        if (moveCount < ValidationConstants.MIN_MOVE_COUNT) {
            throw new IllegalArgumentException(ErrorMessageConstants.ERROR_MOVE_COUNT_NEGATIVE);
        }
    }
}
