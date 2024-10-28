package racingcar.util;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

import static racingcar.error.GameError.*;

public class ConsoleInputValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MINIMUM_CAR_COUNT = 2;

    public static void validateCarNames(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME_INPUT.getMessage());
        }

        String[] names = carNames.split(",");
        validateCarCount(names.length);
        Set<String> nameSet = new HashSet<>();

        Arrays.stream(names)
                .map(String::trim)
                .forEach(name -> {
                    validateCarName(name);
                    validateDuplicateCarNames(nameSet, name);
                });
    }

    private static void validateCarCount(int carCount) {
        if (carCount < MINIMUM_CAR_COUNT) {
            throw new IllegalArgumentException(INVALID_CAR_COUNT.getMessage());
        }
    }

    private static void validateCarName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME_INPUT.getMessage());
        }
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

    private static void validateDuplicateCarNames(Set<String> nameSet, String name) {
        if (!nameSet.add(name)) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME.getMessage());
        }
    }

    public static void validateAttemptCount(int attempts) {
        if (attempts < 1) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_COUNT.getMessage());
        }
    }
}
