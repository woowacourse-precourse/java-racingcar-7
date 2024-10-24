package racingcar.util;

public class Parsing {
    private static final String DELIMITER = ",";

    public String[] splitCarName(String input) {
        return input.split(DELIMITER);
    }
}
