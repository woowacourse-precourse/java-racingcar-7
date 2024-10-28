package racingcar.validator;

import static racingcar.error.NamesErrorMessage.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NamesValidator {
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
        if (input.endsWith(",")) {
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

    private static void checkLetterOrDigit(String input) {
        for (char c : input.toCharArray()) {
            if (!(Character.isLetter(c) || Character.isDigit(c))) {
                throw new IllegalArgumentException(INVALID_NAME.getMessage());
            }
        }
    }
}
