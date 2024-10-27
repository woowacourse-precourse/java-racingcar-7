package racingcar.validation;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidation {
    private final static int MINIMUM_CAR_NUMBER = 1;
    private final static int MAXIMUM_CAR_NAME_LENGTH = 5;

    public static void validate(String input) {
        validateNotNullOrEmpty(input);
        validateIncludeComma(input);
        validateNotEndWithComma(input);
        validateCarName(input);
    }

    private static void validateNotNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIncludeComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNotEndWithComma(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException();
        }
    }


    private static void validateCarName(String input) {
        String[] carNames = input.replaceAll("\\s+", "").split(",");

        Set<String> carNamesSet = new HashSet<>();

        for (String carName : carNames) {
            validateCarNameLength(carName);
            carNamesSet.add(carName);
        }
        validateDuplicateName(carNames.length, carNamesSet.size());
        validateCarCount(carNamesSet);
    }

    private static void validateCarNameLength(String input) {
        if (input.isEmpty() || input.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicateName(int arraySize, int setSize) {
        if (arraySize != setSize) {
            throw new IllegalArgumentException();
        }
    }


    private static void validateCarCount(Set<String> inputs) {
        if (inputs.size() <= MINIMUM_CAR_NUMBER) {
            throw new IllegalArgumentException();
        }

    }

}
