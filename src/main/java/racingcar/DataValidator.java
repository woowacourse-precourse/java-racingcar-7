package racingcar;

import static racingcar.ErrorMessage.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataValidator {
    public static void validateName(String inputName) {
        List<String> namelist = Arrays.asList(inputName.split(","));

        for (int i = 0; i < namelist.size(); i++) {
            namelist.set(i, namelist.get(i).trim());
            checkNonEmpty(namelist.get(i));
            checkLength(namelist.get(i));
            validateAlphaNumeric(namelist.get(i));
        }

        validateEndWith(inputName);
        checkPlayer(namelist);
        checkSame(namelist);
    }

    private static void checkNonEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(NULL_NAME.getMessage());
        }
    }

    private static void checkLength(String input) {
        final int MAX_LENGTH = 5;

        if (input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(LENGTH_EXCEEDED.getMessage());
        }
    }

    private static void validateAlphaNumeric(String input) {
        checkLetterOrDigit(input);
    }

    private static void validateEndWith(String input) {
        if (input.charAt(input.length() - 1) == ',') {
            throw new IllegalArgumentException(NULL_NAME.getMessage());
        }
    }

    private static void checkPlayer(List<String> list) {
        if (!(list.size() >= 2)) {
            throw new IllegalArgumentException(REQUIRED_PLAYER.getMessage());
        }
    }

    private static void checkSame(List<String> list) {
        Set<String> set = new HashSet<>(list);
        if (set.size() < list.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME.getMessage());
        }
    }

    public static int validateTryCount(String inputTryCount) {
        int tryCount;
        try {
            tryCount = Integer.parseInt(inputTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT.getMessage());
        }

        if (tryCount <= 0) {
            throw new IllegalArgumentException(REQUIRED_TRY_COUNT.getMessage());
        }

        return tryCount;
    }

    private static void checkLetterOrDigit(String input) {
        for (char c : input.toCharArray()) {
            if (!(Character.isLetter(c) || Character.isDigit(c))) {
                throw new IllegalArgumentException(INVALID_NAME.getMessage());
            }
        }
    }
}