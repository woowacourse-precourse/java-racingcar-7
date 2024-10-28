package racingcar;

public class Validator {
    private static final Validator instance = new Validator();

    private Validator() {}

    public static Validator getInstance() {
        return instance;
    }

    public void validateTryCounts(String input) {
        validateBlankTryCount(input);
        int numberOfRounds = parseNumber(input);
        validatePositiveNumber(numberOfRounds);
    }

    private void validatePositiveNumber(int tryCounts) {
        if (tryCounts <= 0) {
            throw new IllegalArgumentException("양의 정수만 입력 가능합니다.");
        }
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도횟수는 정수이어야 합니다.");
        }
    }

    private void validateBlankTryCount(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("시도할 횟수를 입력해야합니다.");
        }
    }
}