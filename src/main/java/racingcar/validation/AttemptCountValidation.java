package racingcar.validation;

public class AttemptCountValidation {
    private static void validateIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
    private static void validatePositiveNumber(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
