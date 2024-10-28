package racingcar;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    public static List<String> validateName(String nameInput) {
        List<String> names = extract(nameInput);

        if (names.stream().anyMatch(InputValidator::isInvalidName)) {
            throw new IllegalArgumentException();
        }
        return names;
    }

    private static List<String> extract(String nameInput) {
        return Arrays.stream(nameInput.split(",", -1))
                .map(String::trim)
                .toList();
    }

    private static boolean isInvalidName(String name) {
        return hasSpecialCharacter(name) || isBlank(name) || isOverLength(name);
    }

    private static boolean hasSpecialCharacter(String name) {
        return name.matches(".*[`~!@#$%^&*()\\-_+=\\[\\]{}\\\\|;:\"',.<>/?].*");
    }

    private static boolean isBlank(String name) {
        return name.isBlank();
    }

    private static boolean isOverLength(String name) {
        return name.length() > 5;
    }

    public static int validateStageCount(String countInput) {
        int stageCount = Integer.parseInt(countInput);

        if (isNotPositive(stageCount)) {
            throw new IllegalArgumentException();
        }
        return stageCount;
    }

    private static boolean isNotPositive(int stageCount) {
        return stageCount < 1;
    }
}
