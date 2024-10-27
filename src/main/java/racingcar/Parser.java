package racingcar;

import static racingcar.RegexPatterns.*;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private Parser() {
    }

    public static List<String> splitByDelimiter(String input) {
        return Arrays.stream(input.split(DELIMITER)).toList();
    }

    public static Integer toInteger(String input) {
        return Integer.parseInt(input);
    }
}
