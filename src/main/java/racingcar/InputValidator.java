package racingcar;

public class InputValidator {
    public static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
        }
    }

    public static void validateTrialCount(int trials) {
        if (trials <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
    }

    public static int parseAndValidateTrialCount(String input) {
        try {
            int trials = Integer.parseInt(input.trim());
            validateTrialCount(trials);
            return trials;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
