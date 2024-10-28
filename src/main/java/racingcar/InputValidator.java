package racingcar;

public class InputValidator {
    public static void validateAttemptCount(int attemptCount) {
        if (attemptCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public static void validateCarNames(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
    }
}
