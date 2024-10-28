package racingcar;

public class InputValidator {
    public static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.");
        }

        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열이나 공백일 수 없습니다.");
        }
    }

    public static int parseAndValidateTrialCount(String input) {
        String trimmedInput = input.trim();

        if (trimmedInput.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수는 공백일 수 없습니다.");
        }

        try {
            int trials = Integer.parseInt(trimmedInput);

            if (trials <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
            }

            return trials;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
