package racingcar.util;

public class InputValidator {

    private InputValidator() {

    }

    public static void checkCarNameEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkTryNumNegative(int tryNum) {
        if (tryNum <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
