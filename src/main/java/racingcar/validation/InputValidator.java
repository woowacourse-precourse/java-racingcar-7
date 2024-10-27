package racingcar.validation;

public class InputValidator {

    public static boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

    public static boolean isValidFormat(String input) {
        return input.matches("^([a-zA-Z1-9]{1,5})(,[a-zA-Z1-9]{1,5})*$");
    }

    public static boolean isValidNumber(String input) {
        return input.matches("^[1-9]\\d*$");
    }
}
