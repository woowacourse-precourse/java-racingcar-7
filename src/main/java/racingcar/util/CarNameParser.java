package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {

    private CarNameParser() {
    }


    public static List<String> parseCarName(String rawCarNames) {
        return Arrays
                .stream(rawCarNames.split(","))
                .map(String::trim)
                .toList();
    }
}
