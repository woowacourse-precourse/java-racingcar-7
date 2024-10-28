package racingcar;

public class AttemptValidator {
    public static int validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("시도 횟수는 빈 문자열일 수 없습니다.");
        }
        if (input.contains(" ")) {
            throw new IllegalArgumentException("시도 횟수는 공백을 포함할 수 없습니다.");
        }
        try {
            int attemptCount = Integer.parseInt(input);
            if (attemptCount < 1) {
                throw new IllegalArgumentException("시도 횟수는 1 이상의 양수여야 합니다.");
            }
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
        }
    }
}
