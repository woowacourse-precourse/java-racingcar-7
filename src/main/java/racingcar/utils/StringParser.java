package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    public static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(StringParser::validateWordLength)
                .collect(Collectors.toList());
    }

    private static String validateWordLength(String word) {
        if (word.length() > 5) {
            throw new IllegalArgumentException();
        }
        return word;
    }
}
