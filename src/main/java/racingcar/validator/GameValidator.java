package racingcar.validator;

public class GameValidator {
    private static void isPositiveAttemptCount(int attemptCount) {
        if (attemptCount < 1) {
            throw new IllegalArgumentException("1 이상의 숫자를 입력하세요.");
        }
    }

    public static int validateAttemptCount(String input) {
        try {
            int attemptCount = Integer.parseInt(input);
            isPositiveAttemptCount(attemptCount);
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요");
        }
    }
}
