package racingcar.validation;

import racingcar.constants.ErrorMessageConstants;
import racingcar.constants.ValidationConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {
    public static void validateCarNames(List<String> carNames) {
        validateCarCount(carNames);
        for (String name : carNames) {
            validateNullOrEmptyCarName(name);
            validateNameContainsBlank(name);
            validateNameLength(name);
            validateNameHasInvalidCharacters(name);
        }
        validateUniqueCarNames(carNames);
    }

    private static void validateCarCount(List<String> carNames) {
        if (carNames.size() < ValidationConstants.MIN_CAR_COUNT) {
            throw new IllegalArgumentException(ErrorMessageConstants.ERROR_CAR_COUNT_LESS_THAN_TWO);
        }
    }

    private static void validateNullOrEmptyCarName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessageConstants.ERROR_EMPTY_CAR_NAME);
        }
    }

    private static void validateNameContainsBlank(String name) {
        if (name.matches(".*\\s.*")) {
            throw new IllegalArgumentException(ErrorMessageConstants.ERROR_CAR_NAME_CONTAINS_BLANK);
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > ValidationConstants.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessageConstants.ERROR_CAR_NAME_TOO_LONG);
        }
    }

    private static void validateNameHasInvalidCharacters(String name) {
        if (!name.matches("[a-zA-z0-9]+")) {
            throw new IllegalArgumentException(ErrorMessageConstants.ERROR_CAR_NAME_INVALID_CHARACTERS);
        }
    }

    private static void validateUniqueCarNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException(ErrorMessageConstants.ERROR_CAR_NAME_DUPLICATE);
        }
    }
}
