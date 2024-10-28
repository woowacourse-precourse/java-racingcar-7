package racingcar.utils;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MAX_CAR_COUNT = 100;
    public static final int MAX_TRY_COUNT = 1000;

    private ValidationUtils() {} //인스턴스화 방지

    public static void validateCarNames(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException(ErrorMessages.CAR_COUNT_EMPTY.getMessage());
        }
        if (carNames.length > MAX_CAR_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.CAR_COUNT_EXCEEDED.getMessage());
        }

        Set<String> nameSet = new HashSet<>();
        for (String name : carNames) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException(ErrorMessages.CAR_NAME_EMPTY.getMessage());
            }
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(ErrorMessages.CAR_NAME_TOO_LONG.getMessage());
            }
            if (!name.matches("[a-zA-Z0-9]+")) {
                throw new IllegalArgumentException(ErrorMessages.CAR_NAME_INVALID.getMessage());
            }
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException(ErrorMessages.CAR_NAME_DUPLICATED.getMessage());
            }
        }
    }

    public static boolean isAlphanumeric(String input) {
        return input.matches("[a-zA-Z0-9]+");
    }

    public static void validateTryCount(int tryCount) {
        if (tryCount <= 0 || tryCount > MAX_TRY_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.TRY_COUNT_INVALID.getMessage());
        }
    }
}