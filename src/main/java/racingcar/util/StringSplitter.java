package racingcar.util;

import java.util.List;

public class StringSplitter {

    private static final String DELIMITER = ",";

    public static List<String> splitByComma(String input) {
        return List.of(input.split(DELIMITER));
    }
}
