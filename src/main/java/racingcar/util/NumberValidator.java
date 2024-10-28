package racingcar.util;

public class NumberValidator {

    private NumberValidator() {
    }

    public static boolean isPositiveInteger(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        try {
            int number = Integer.parseInt(input);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}