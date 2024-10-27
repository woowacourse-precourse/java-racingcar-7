package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {
    public static String CAR_NAME_DEFAULT_DELIMITER = ",";

    public static List<String> parse(String input) {
        return Arrays.asList(input.split(CAR_NAME_DEFAULT_DELIMITER));
    }
}
