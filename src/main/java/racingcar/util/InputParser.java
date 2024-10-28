package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.exception.InputException;

public final class InputParser {
    private static final String DELIMITER = ",";

    private InputParser() {
    }

    public static List<String> parseName(String input) {
        validateInput(input);
        var names = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .toList();
        validateNameCount(names, input);

        return names;
    }

    private static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(InputException.INPUT_IS_NULL_OR_EMPTY.getMessage());
        }
    }

    private static void validateNameCount(List<String> names, String input) {
        var delimiterCount = (int) input.chars().filter(ch -> ch == DELIMITER.charAt(0)).count();
        if (isNameSameWithDelimiterCount(names, delimiterCount)) {
            throw new IllegalArgumentException(InputException.NAME_IS_EMPTY.getMessage());
        }
    }

    private static boolean isNameSameWithDelimiterCount(List<String> names, int delimiterCount) {
        return delimiterCount + 1 != names.size();
    }
}
