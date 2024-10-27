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
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

    private static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(InputException.INPUT_IS_NULL_OR_EMPTY.getMessage());
        }
    }
}
