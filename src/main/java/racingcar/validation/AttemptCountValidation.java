package racingcar.validation;

public class AttemptCountValidation {
    public static void validate(String input) {
        validateIsInteger(input);
        validatePositiveNumber(input);
    }

    private static void validateIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validatePositiveNumber(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
