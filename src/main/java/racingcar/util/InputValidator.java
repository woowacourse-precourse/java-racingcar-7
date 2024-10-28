package racingcar.util;

public class InputValidator {

    private static final int MAX_NAME_LENGTH = 5;

    private InputValidator() {

    }

    public static void checkCarNameEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkCarNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkTryNumNegative(int tryNum) {
        if (tryNum <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
