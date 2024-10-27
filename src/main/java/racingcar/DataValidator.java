package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataValidator {
    public static void validName(String input) {
        List<String> list = Arrays.asList(input.split(","));

        for (int i = 0; i < list.size(); i++) {
            isNonEmpty(list.get(i));
            list.set(i, list.get(i).trim());
            checkLength(list.get(i));
            isAlphaNumeric(list.get(i));
        }

        endWith(input);
        isSame(list);
    }

    private static void isNonEmpty(String input) {
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

    private static void isAlphaNumeric(String input) {
        isLetterOrDigit(input);
    }

    private static void endWith(String input) {
        if (input.charAt(input.length() - 1) == ',') {
            throw new IllegalArgumentException();
        }
    }

    private static void isSame(List<String> list) {
        Set<String> set = new HashSet<>(list);
        if (set.size() < list.size()) {
            throw new IllegalArgumentException("중복 작성");
        }
    }

    public static int validCount(String tryCount) {
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

    private static void isLetterOrDigit(String input) {
        for (char c : input.toCharArray()) {
            if (!(Character.isLetter(c) || Character.isDigit(c))) {
                throw new IllegalArgumentException();
            }
        }
    }
}