package racingcar.view;

public class InputValidator {

    public static void validateCarNames(String input) {
        validateBlanckInput(input);
    }

    public static void validateTotalRounds(String input) {
        validateBlanckInput(input);
        validateNumericInput(input);
        validatePositiveInteger(input);
    }

    private static void validateBlanckInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    private static void validateNumericInput(String input) {
        try {
            int rounds = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
        }
    }

    private static void validatePositiveInteger(String input) {
        int rounds = Integer.parseInt(input);
        if (rounds <= 0) {
            throw new IllegalArgumentException("이동 횟수는 1 이상의 자연수여야 합니다.");
        }
    }

}