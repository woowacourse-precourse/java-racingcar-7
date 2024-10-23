package racingcar.view;

public class InputValidator {
    public static void validateAttemptCount(final String input) {
        if (isNotPositiveInteger(input)) {
            throw new IllegalArgumentException("시도할 횟수는 양의 정수 형태로 입력하셔야 합니다.");
        }
    }

    private static boolean isNotPositiveInteger(String input) {
        return !input.matches("^[1-9]\\d*$");
    }
}
