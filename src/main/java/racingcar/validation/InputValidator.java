package racingcar.validation;

import racingcar.constants.ErrorMessages;
import racingcar.constants.ValidationConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            validateNullOrEmptyCarName(name);
            validateNameContainsBlank(name);
            validateNameLength(name);
        }
        validateUniqueCarNames(carNames);
    }

    public static void validateMoveCount(String moveCountInput) {
        validateNullOrEmptyMoveCount(moveCountInput);
        validateNumericAndPositive(moveCountInput);
    }

    private static void validateNullOrEmptyCarName(String name) {
        if (name == null || name.trim().isEmpty()) {
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

    private static void validateUniqueCarNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_CAR_NAME_DUPLICATE);
        }
    }

    private static void validateNullOrEmptyMoveCount(String moveCountInput) {
        if (moveCountInput == null || moveCountInput.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_EMPTY_MOVE_COUNT);
        }
    }

    private static void validateNumericAndPositive(String moveCountInput) {
        try {
            int moveCount = Integer.parseInt(moveCountInput);
            validatePositiveMoveCount(moveCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_MOVE_COUNT_NOT_NUMBER);
        }
    }

    private static void validatePositiveMoveCount(int moveCount) {
        if (moveCount < ValidationConstants.MIN_MOVE_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_MOVE_COUNT_NEGATIVE);
        }
    }
}
