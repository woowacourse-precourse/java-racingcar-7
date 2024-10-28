package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static List<String> validateCarGameInput(String input) {
        validateInputNotEmpty(input);
        List<String> names = splitAndTrimNames(input);
        validateCarNames(names);
        return names;
    }

    private static List<String> splitAndTrimNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }

    private static void validateInputNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 최소 하나 이상 입력해야 합니다.");
        }
    }

    private static void validateCarNames(List<String> names) {
        validateCarNameLength(names);
        validateUniqueNames(names);
    }

    private static void validateCarNameLength(List<String> names) {
        names.forEach(Validator::validateSingleCarNameLength);
    }

    private static void validateSingleCarNameLength(String name) {
        if (name.trim().isEmpty() || name.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다: " + name);
        }
    }

    private static void validateUniqueNames(List<String> names) {
        Set<String> uniqueNames = new HashSet<>();
        names.forEach(name -> checkForDuplicateName(uniqueNames, name));
    }

    private static void checkForDuplicateName(Set<String> uniqueNames, String name) {
        if (!uniqueNames.add(name.trim())) {
            throw new IllegalArgumentException("중복된 이름이 있습니다: " + name);
        }
    }

    public static int validateTrialCount(String input) {
        return parseTrialCount(input);
    }

    private static int parseTrialCount(String input) {
        try {
            int count = Integer.parseInt(input);
            validateTrialCountPositive(count);
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private static void validateTrialCountPositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
