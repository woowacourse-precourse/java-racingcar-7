package racingcar;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private static final int KEEP_EMPTY_STRING = -1;
    private static final String SPECIAL_CHARACTER_REGEX = ".*[`~!@#$%^&*()\\-_+=\\[\\]{}\\\\|;:\"',.<>/?].*";
    private static final int MAX_NAME_LENGTH = 5;
    private static final int POSITIVE = 1;

    public static List<String> validateName(String nameInput) {
        List<String> names = extract(nameInput);

        if (names.stream().anyMatch(InputValidator::isInvalidName)) {
            throw new IllegalArgumentException();
        }
        return names;
    }

    private static List<String> extract(String nameInput) {
        return Arrays.stream(nameInput.split(",", KEEP_EMPTY_STRING))
                .map(String::trim)
                .toList();
    }

    private static boolean isInvalidName(String name) {
        return hasSpecialCharacter(name) || isBlank(name) || isOverLength(name);
    }

    private static boolean hasSpecialCharacter(String name) {
        return name.matches(SPECIAL_CHARACTER_REGEX);
    }

    private static boolean isBlank(String name) {
        return name.isBlank();
    }

    private static boolean isOverLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    public static int validateCount(String countInput) {
        int count = Integer.parseInt(countInput);

        if (isNotPositive(count)) {
            throw new IllegalArgumentException();
        }
        return count;
    }

    private static boolean isNotPositive(int count) {
        return count < POSITIVE;
    }
}
