package racingcar.validation;

import java.util.Set;

public class CarNameValidation {
    public static void validate(String input) {

    }

    private static void validateNotNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateIncludeComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNameLength(Set<String> inputs) {
        if (inputs.stream().anyMatch(input -> input.length() > 5)) {
            throw new IllegalArgumentException();
        }
    }

}
