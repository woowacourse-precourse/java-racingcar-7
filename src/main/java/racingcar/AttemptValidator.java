package racingcar;

public class AttemptValidator {
    private static final String NOT_A_NUMBER_ERROR = "시도 횟수는 숫자여야 합니다.";
    private static final String INVALID_ATTEMPT_ERROR = "시도 횟수는 1 이상이어야 합니다.";

    public static int validateAttempt(String input) {
        try {
            int attempt = Integer.parseInt(input);
            validateAttemptCount(attempt);
            return attempt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER_ERROR);
        }
    }

    private static void validateAttemptCount(int attempt) {
        if (attempt < 1) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_ERROR);
        }
    }
}
