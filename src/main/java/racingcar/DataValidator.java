package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataValidator {
    public static void validateName(String input) {
        List<String> list = Arrays.asList(input.split(","));

        for (int i = 0; i < list.size(); i++) {
            checkNonEmpty(list.get(i));
            list.set(i, list.get(i).trim());
            checkLength(list.get(i));
            validateAlphaNumeric(list.get(i));
        }

        validateEndWith(input);
        checkSame(list);
    }

    private static void checkNonEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkLength(String input) {
        final int MAX_LENGTH = 5;

        if (input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateAlphaNumeric(String input) {
        checkLetterOrDigit(input);
    }

    private static void validateEndWith(String input) {
        if (input.charAt(input.length() - 1) == ',') {
            throw new IllegalArgumentException();
        }
    }

    private static void checkSame(List<String> list) {
        Set<String> set = new HashSet<>(list);
        if (set.size() < list.size()) {
            throw new IllegalArgumentException("중복 작성");
        }
    }

    public static int validateTryCount(String tryCount) {
        for (char c : tryCount.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
        if (Integer.parseInt(tryCount) <= 0) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(tryCount);
    }

    private static void checkLetterOrDigit(String input) {
        for (char c : input.toCharArray()) {
            if (!(Character.isLetter(c) || Character.isDigit(c))) {
                throw new IllegalArgumentException();
            }
        }
    }
}