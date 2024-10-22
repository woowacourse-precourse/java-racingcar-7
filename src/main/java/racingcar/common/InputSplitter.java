package racingcar.common;

public class InputSplitter {

    private static final String DEFAULT_DELIMITER = ",";

    public static String[] split(final String input) {
        return input.split(DEFAULT_DELIMITER);
    }
}
