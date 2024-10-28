package racingcar.util;

import java.util.List;

public class StringUtil {

    private static final String DELIMITER = ",";

    private StringUtil() {
    }

    public static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static List<String> splitByComma(String input) {
        return List.of(input.split(DELIMITER));
    }

}
