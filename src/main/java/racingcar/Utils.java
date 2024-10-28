package racingcar;

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static List<String> splitByDelimiter(String input) {
        return Arrays.asList(input.split(","));
    }
}
