package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputConverter {
    private static final String COMMA = ",";

    public static List<String> convertNames(String input) {
        String trimmedInput = input.trim();
        return Arrays.stream(trimmedInput.split(COMMA))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
