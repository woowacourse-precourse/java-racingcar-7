package racingcar.common;

import java.util.List;

public class InputSplitter {

    private static final String DEFAULT_DELIMITER = ",";

    public static String[] split(final String input) {
        return input.split(DEFAULT_DELIMITER);
    }

    public static String join(final List<String> elements) {
        return String.join(", ", elements);
    }
}
