package racingcar.validator;

public class InputValidator {
    public static void checkMaxLength5(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("Input exceeds maximum length of 5 characters.");
        }
    }
    public static int parseIntWithValidation(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input is not a valid integer: " + input);
        }
    }
}