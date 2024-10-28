package racingcar.global.parser;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(","))
                .map(String::strip)
                .toList();
    }
}
