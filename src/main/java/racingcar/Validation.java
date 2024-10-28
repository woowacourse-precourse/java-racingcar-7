package racingcar;
public class Validation {
    public static void validateCarNames(String[] carNames) {
        if (carNames == null || carNames.length == 0) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
        }
        for (String name : carNames) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }
    }
    public static void validateAttemptCount(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("시도 횟수를 입력해 주세요.");
        }

        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    public static void validateDelimiter(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("입력 값에 쉼표(,)가 포함되어야 합니다.");
        }
    }
}
