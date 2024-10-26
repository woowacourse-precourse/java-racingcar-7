package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Cars;

public class Validator {
    private static final String VALID_NAME_PATTERN = "^[a-zA-Z0-9]+$";
    private static final String PRINTABLE_PATTERN = "\\p{Print}+";

    public static void carNameValidate(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>();

        if (carNames.size() > Cars.MAX_CAR_COUNT) {
            throw new IllegalArgumentException();
        }
        if (carNames.size() == 0) {
            throw new IllegalArgumentException();
        }
        for (String carName : carNames) {
            if (carName == null || carName.isBlank()) {
                throw new IllegalArgumentException();
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            if (!uniqueCarNames.add(carName)) {
                throw new IllegalArgumentException();
            }
            if (!carName.matches(VALID_NAME_PATTERN)) {
                throw new IllegalArgumentException();
            }
            if (!carName.matches(PRINTABLE_PATTERN)) {
                throw new IllegalArgumentException();
            }
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
        if (number > 1000) {
            throw new IllegalArgumentException("Input must be less than or equal to 1000.");
        }
    }
}
