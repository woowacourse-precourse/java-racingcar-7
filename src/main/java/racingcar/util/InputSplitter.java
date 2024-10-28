package racingcar.util;

import java.util.List;

public class InputSplitter {

    private final static String COMMA_DELIMITER = ",";

    public static List<String> splitByComma(String input) {
        return List.of(input.split(COMMA_DELIMITER));
    }
}
