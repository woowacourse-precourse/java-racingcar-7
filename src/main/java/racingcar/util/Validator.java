package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static List<String> validateCarGameInput(String input) {
        validateInputNotEmpty(input);
        List<String> names = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
        validateCarNames(names);
        return names;
    }

    private static void validateInputNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 최소 하나 이상 입력해야 합니다.");
        }
    }

    private static void validateCarNames(List<String> names) {
        validateCarNameLength(names);
        checkForDuplicateNames(names);
    }

    private static void validateCarNameLength(List<String> names) {
        for (String name : names) {
            if (name.trim().isEmpty() || name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다: " + name);
            }
        }
    }

    private static void checkForDuplicateNames(List<String> names) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            if (!uniqueNames.add(name.trim())) {
                throw new IllegalArgumentException("중복된 이름이 있습니다: " + name);
            }
        }
    }

    public static int validateTrialCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
