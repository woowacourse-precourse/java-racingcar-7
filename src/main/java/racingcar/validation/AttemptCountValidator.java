package racingcar.validation;

public class AttemptCountValidator {
    private AttemptCountValidator() {
    }

    public static void validateInteger(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수가 입력되지 않았습니다.");
        }

        try {
            Integer.parseInt(input);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("시도 횟수가 정수 형태가 아닙니다.");
        }
    }

    public static void validateNonNegative(Integer attemptCount) {
        if (attemptCount < 0) {
            throw new IllegalArgumentException("시도 횟수가 음수입니다.");
        }
    }
}
