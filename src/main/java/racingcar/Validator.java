package racingcar;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarNames(List<String> names) {
        validateNotEmpty(names);
        validateNameLength(names);
        validateDuplicateNames(names);
    }

    private static void validateNotEmpty(List<String> names) {
        if (names == null || names.isEmpty() || names.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNameLength(List<String> names) {
        if (names.stream().anyMatch(name -> name.length() > MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicateNames(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateTryCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}