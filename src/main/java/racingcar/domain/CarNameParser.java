package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {
    public static List<String> parse(String input) {
        return Arrays.asList(input.split(","));
    }
}
