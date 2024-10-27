package racingcar.util;

import java.util.Arrays;
import java.util.List;

public final class InputParser {
    private static final String DELIMITER = ",";

    private InputParser() {
    }

    public static List<String> parseName(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .toList();
    }
}
