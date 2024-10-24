package racingcar.util;

public class InputValidator {

    public static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
