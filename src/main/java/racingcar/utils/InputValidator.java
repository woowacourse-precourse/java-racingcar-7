package racingcar.utils;

public class InputValidator {
    public static void validateRoundCount(String roundCountInput) {
        try {
            int round = Integer.parseInt(roundCountInput);
            if(round <= 0) {
                throw new IllegalArgumentException("시도할 횟수는 양의 정수만 입력할 수 있습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자만 입력할 수 있습니다.");
        }
    }

    public static void validateNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
    }
}
