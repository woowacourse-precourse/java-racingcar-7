package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    private static final String DELIMITER = ",";

    public List<String> makeList(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .toList();
    }
}
