package racingcar.exception;

public final class InputValidation {

    private InputValidation() {
    }

    public static boolean validateNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public static boolean validateBlank(String input) {
        return input.contains(" ");
    }
}
