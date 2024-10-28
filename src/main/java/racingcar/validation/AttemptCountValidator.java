package racingcar.validation;

public class AttemptCountValidator implements Validator {

    @Override
    public void validate(String attemptCount) {
        validateNotBlank(attemptCount);
        validateDigitOnly(attemptCount);
        validateRange(attemptCount);
        validatePositive(attemptCount);
    }

    private void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("시도 횟수를 입력해주세요.");
        }
    }

    private void validateDigitOnly(String input) {
        if (!input.matches("^\\d+$")) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validateRange(String attemptCount) {
        try {
            Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수가 너무 큽니다.");
        }
    }

    private void validatePositive(String attemptCount) {
        if (Long.parseLong(attemptCount) <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }
    }
}
