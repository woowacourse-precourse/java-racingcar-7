package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public final class Parser {
    public static List<String> parse(String input) {
        return Arrays.stream(input.split(",")).toList();
    }
}
