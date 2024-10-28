package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> parse(String carName) {
        return Arrays.asList(carName.split(","));
    }
}
