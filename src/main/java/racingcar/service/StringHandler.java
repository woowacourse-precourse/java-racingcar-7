package racingcar.service;

import java.util.List;

public class StringHandler {

    private static final String SPLIT_DELIMITER = ",";
    private static final String JOIN_DELIMITER = ", ";

    public String[] split(String input) {
        return input.split(SPLIT_DELIMITER);
    }

    public String join(List<String> list) {
        return String.join(JOIN_DELIMITER, list);
    }

    public int StringToInt(String input) {

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
