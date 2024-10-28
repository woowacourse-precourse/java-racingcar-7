package racingcar;

public class InputValidator {
    public static void validateCarName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 비어 있을 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public static int validateAttempts(String attempts) {
        int validAttempts;
        try {
            validAttempts = Integer.parseInt(attempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
        if (validAttempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }

        return validAttempts;
    }
}