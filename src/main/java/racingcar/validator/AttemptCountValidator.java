package racingcar.validator;

public class AttemptCountValidator {

    public void validate(String attemptCountString) {
        checkNullOrEmpty(attemptCountString); // null 또는 빈 문자열 체크
        validateIsInteger(attemptCountString); // 숫자 확인
        validateIsPositive(attemptCountString); // 양수 확인
    }

    private void checkNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값은 null이거나 빈 문자열일 수 없습니다.");
        }
    }

    private void validateIsInteger(String attemptCountString) {
        try {
            Integer.parseInt(attemptCountString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 정수여야 합니다.");
        }
    }

    private void validateIsPositive(String attemptCountString) {
        int attemptCount = Integer.parseInt(attemptCountString); // 문자열을 정수로 변환
        if (attemptCount <= 0) {
            throw new IllegalArgumentException("입력값은 양수여야 합니다.");
        }
    }
}