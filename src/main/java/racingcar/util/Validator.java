package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Cars;
import racingcar.model.Game;

public class Validator {
    private static final String VALID_NAME_PATTERN = "^[a-zA-Z0-9]+$";
    private static final String PRINTABLE_PATTERN = "\\p{Print}+";

    public static void carNamesValidate(List<String> carNames) {
        validateCarListSize(carNames);
        validateCarNames(carNames);
        checkForDuplicateNames(carNames);
    }

    private static void validateCarListSize(List<String> carNames) {
        if (carNames.isEmpty() || carNames.size() > Cars.MAX_CAR_COUNT) {
            throw new IllegalArgumentException("Car list size is invalid");
        }
    }

    private static void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            validateCarName(carName);
        }
    }

    private static void validateCarName(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("Car name cannot be null or blank");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("Car name cannot exceed 5 characters");
        }
        if (!carName.matches(VALID_NAME_PATTERN) || !carName.matches(PRINTABLE_PATTERN)) {
            throw new IllegalArgumentException("Car name contains invalid characters");
        }
    }

    private static void checkForDuplicateNames(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>(carNames);
        if (uniqueCarNames.size() < carNames.size()) {
            throw new IllegalArgumentException("Car names must be unique");
        }
    }


    public static void gameRoundValidate(String input) {
        validateNullOrBlank(input);
        double number = parseToDouble(input);
        validatePositiveInteger(number);
        validateWithinMaxLimit(number);
    }

    private static void validateNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank.");
        }
    }

    private static double parseToDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input must be a valid number.");
        }
    }

    private static void validatePositiveInteger(double number) {
        if (number <= 0 || number != (int) number) {
            throw new IllegalArgumentException("Input must be a positive integer.");
        }
    }

    private static void validateWithinMaxLimit(double number) {
        if (number > Game.MAX_GAME_ROUND) {
            throw new IllegalArgumentException("Input must be less than or equal to 1000.");
        }
    }
}
