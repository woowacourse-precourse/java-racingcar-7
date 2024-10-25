package racingcar.exception;

import java.util.HashSet;
import java.util.Set;

public class InvalidInputException {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateInput(String carName) {
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_BLANK_IS_NOT_ALLOWED.getMessage());
        }
    }

    public static void validateCarNames(String[] carNames) {
        Set<String> test = new HashSet<>();
        validateCarNameSize(carNames);
        for (String carName : carNames) {
            validateCarNameBlankInput(carName);
            validateDuplicateName(carName, test);
            validateMaxCarNameLength(carName);
        }
    }

    private static void validateCarNameSize(String[] carNames) {
        if (carNames.length == 1) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_AT_LEAST_TWO_CAR.getMessage());
        }
    }

    private static void validateCarNameBlankInput(String carName) {
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_BLANK_IS_NOT_ALLOWED.getMessage());
        }
    }

    private static void validateDuplicateName(String carName, Set<String> test) {
        if (!test.add(carName)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_INPUT.getMessage());
        }
    }

    private static void validateMaxCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEED_MAX_INPUT_LENGTH.getMessage());
        }
    }

    public static void validateAttemptCount(int attemptCount) {
        if (attemptCount < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_ONLY_POSITIVE_INTEGER.getMessage());
        }
    }
}
