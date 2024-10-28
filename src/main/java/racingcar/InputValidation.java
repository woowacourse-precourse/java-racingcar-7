package racingcar;

public class InputValidation {
    public static void validateNull(final String input) {
        if (isNull(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static Boolean isNull(final String input) {
        return input == null;
    }
}
