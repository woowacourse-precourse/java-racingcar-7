package racingcar.validation;

public class ValidatorUtil {

    public static boolean isNumeric(String input) {
        return input.matches("\\d+");
    }

    public static boolean isEmptyInput(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean containsWhitespace(String input) {
        return input != null && input.contains(" ");
    }
}
