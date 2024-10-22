package racingcar.common;

import java.util.List;

public class InputSplitter {

    private static final String DEFAULT_DELIMITER = ",";
    private static final String DEFAULT_JOINER = ", ";

    public static String[] split(final String input) {
        return input.split(DEFAULT_DELIMITER, -1);
    }

    public static String join(final List<String> carNames) {
        return String.join(DEFAULT_JOINER, carNames);
    }
}
