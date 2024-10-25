package racingcar.validator;

public class AttemptCountValidator {

    public static void validateAttemptCount(int attemptCount) {
        if (attemptCount < 0) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }
    }
}
