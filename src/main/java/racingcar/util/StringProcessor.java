package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringProcessor {

    private final static String COMMA = ",";

    public static String[] process(String input) {

        if (input.endsWith(COMMA)) {
            throw new IllegalArgumentException();
        }

        String[] tokens = split(input);

        return Arrays.stream(tokens)
            .map(StringProcessor::trim)
            .toArray(String[]::new);
    }

    public static String formatWinner(List<String> winners) {

        return String.join(", ", winners);
    }

    private static String trim(String input) {

        return input.trim();
    }

    private static String[] split(String input) {

        return input.split(COMMA);
    }
}
