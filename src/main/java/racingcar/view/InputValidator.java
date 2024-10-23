package racingcar.view;

public class InputValidator {
    public static void validateNameOfCars(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 빈 문자열이어서는 안됩니다.");
        }
    }

    public static void validateAttemptCount(final String input) {
        if (input.isBlank() || isNotPositiveInteger(input)) {
            throw new IllegalArgumentException("시도할 횟수는 양의 정수 형태로 입력하셔야 합니다.");
        }
    }

    private static boolean isNotPositiveInteger(String input) {
        return !input.matches("^[1-9]\\d*$");
    }
}
