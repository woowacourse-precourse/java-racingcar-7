package racingcar.utills;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    public static List<String> splitAndTrim(String input, String delimiter) {
        if (input == null || input.isBlank()) {
            return Collections.emptyList();
        }

        return Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
