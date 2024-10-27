package racingcar.validation;

public class AttemptCountValidation {
    private final static int MINIMUM_ATTEMPT_COUNT = 1;

    public static void validate(String input) {
        validateNotNullOrEmpty(input);
        validateIsInteger(input);
        validatePositiveNumber(input);
    }

    private static void validateNotNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validatePositiveNumber(String input) {
        if (Integer.parseInt(input) < MINIMUM_ATTEMPT_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
