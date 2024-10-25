package racingcar.utils;

public class InputValidator {
    private static final String ERROR_MESSAGE_EMPTY_INPUT = "입력값은 공백일 수 없습니다.";

    public static void validateCarNamesInput(String input) {
        checkEmptyInput(input);
    }

    public static void validateAttemptCountInput(String input) {
        checkEmptyInput(input);
    }

    private static void checkEmptyInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY_INPUT);
        }
    }
}
