package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Splitter {
    public static List<String> split(String input) {
        return Arrays.stream(input.split(",")).toList();
    }
}
