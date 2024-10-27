package racingcar.util;

import java.util.List;

public class ValidationUtil {
    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public static boolean isPositive(String input) {
        return Integer.parseInt(input) > 0;
    }

    public static boolean isDuplicate(List<?> items) {
        return items.stream().distinct().count() != items.size();
    }
}
