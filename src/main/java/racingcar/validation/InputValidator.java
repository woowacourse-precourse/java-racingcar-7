package racingcar.validation;

import racingcar.Constants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static void validateCarName(String name) {
        if (name.length() > Constants.CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(Constants.ERROR_NAME_LENGTH);
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(Constants.ERROR_EMPTY_NAME);
        }
    }

    public static void validateMovement(String movementInput) {
        int movement = Integer.parseInt(movementInput);
        if (movement <= 0) {
            throw new IllegalArgumentException(Constants.ERROR_MOVEMENT_ZERO);
        }
    }

    public static void validateInputFormat(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(Constants.ERROR_INVALID_FORMAT);
        }
    }

    public static void validateDuplicateCarNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException(Constants.ERROR_DUPLICATE_NAME);
        }
    }

    public static void validateCarNamesSeparator(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(Constants.ERROR_INVALID_SEPARATOR);
        }
        if (!input.matches("[a-zA-Z0-9,]*")) {
            throw new IllegalArgumentException(Constants.ERROR_INVALID_SEPARATOR);
        }
    }

    public static void validateMovementString(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.ERROR_NON_NUMERIC, e);
        }
    }
}
