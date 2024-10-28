package racingcar.validation;

import java.util.HashSet;
import java.util.Set;

import static racingcar.constant.ErrorMessage.*;
import static racingcar.constant.SeparatorConstant.*;

public class CarNameValidation {
    private final static int MINIMUM_CAR_NUMBER = 2;
    private final static int MAXIMUM_CAR_NAME_LENGTH = 5;

    public static void validate(String input) {
        validateNotNullOrEmpty(input);
        validateIncludeComma(input);
        validateNotEndWithComma(input);
        validateCarName(input);
    }

    private static void validateNotNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_CANNOT_BE_NULL_OR_EMPTY.getMessage());
        }
    }

    private static void validateIncludeComma(String input) {
        if (!input.contains(COMMA.getSeparator())) {
            throw new IllegalArgumentException(CAR_NAME_MUST_BE_SEPARATED_BY_COMMAS.getMessage());
        }
    }

    private static void validateNotEndWithComma(String input) {
        if (input.endsWith(COMMA.getSeparator())) {
            throw new IllegalArgumentException(CAR_NAME_CANNOT_END_WITH_COMMA.getMessage());
        }
    }

    private static void validateCarName(String input) {
        String[] carNames = input.replaceAll(SPACE.getSeparator(), EMPTY.getSeparator()).split(COMMA.getSeparator());

        Set<String> carNamesSet = new HashSet<>();

        for (String carName : carNames) {
            validateCarNameLength(carName);
            carNamesSet.add(carName);
        }
        validateDuplicateName(carNames.length, carNamesSet.size());
    }

    private static void validateCarNameLength(String input) {
        if (input.isEmpty() || input.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_INVALID.getMessage());
        }
    }

    private static void validateDuplicateName(int arraySize, int setSize) {
        if (arraySize != setSize) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME_FOUND.getMessage());
        }
    }


}
