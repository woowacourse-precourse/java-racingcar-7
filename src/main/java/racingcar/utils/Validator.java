package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_ATTEMPT_COUNT = 0;

    public static void isEmpty(String name) {
        if (isNull(name) || isBlank(name)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME.getMessage());
        }
    }

    public static void isCarNameRange(String name) {
        if (name.length() < MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_TOO_SHORT.getMessage());
        }
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_TOO_LONG.getMessage());
        }
    }

    public static void checkLastIndexAndThrowException(String input) {
        if (input.lastIndexOf(",") == input.length() - 1) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_TOO_SHORT.getMessage());
        }
    }

    public static void containDuplicate(List<String> names) {
        Set<String> uniqueCars = new HashSet<>(names);
        if (uniqueCars.size() != names.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
        }
    }

    public static void isNegative(int attemptCount) {
        if (attemptCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_TRY_COUNT.getMessage());
        }
    }

    public static void isZero(int attemptCount) {
        if (attemptCount == 0) {
            throw new IllegalArgumentException(ErrorMessage.ZERO_TRY_COUNT.getMessage());
        }
    }

    public static void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException exception){
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_TRY_COUNT.getMessage());
        }
    }

    private static boolean isNull(String name) {
        return name == null;
    }

    private static boolean isBlank(String name) {
        return name.trim().isBlank();
    }

}
