package racingcar.validation;

public class InputValidator {

    public static boolean isNullOrBlank(String input) {
        return input.isBlank() || input == null;
    }

    public static boolean isValidFormat(String input) {
        return input.matches("^([a-zA-Z]{1,5})(,[a-zA-Z]{1,5})*$");
    }

    public static boolean isValidNumber(String input) {
        return input.matches("^[1-9]\\d*$");
    }
}
