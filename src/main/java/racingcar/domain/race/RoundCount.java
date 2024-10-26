package racingcar.domain.race;

public class RoundCount {
    private final int roundCount;

    public RoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public static RoundCount from(String input) {
        validateInputBlank(input);
        validatePositiveNumber(input);
        return new RoundCount(Integer.parseInt(input));
    }

    private static void validateInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("시도할 횟수를 입력해 주세요.");
        }
    }

    private static void validatePositiveNumber(String input) {
        try {
            int roundCount = Integer.parseInt(input);
            validateNegativeNumber(roundCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("양의 정수를 입력해 주세요.");
        }
    }

    private static void validateNegativeNumber(int roundCount) {
        if (roundCount < 0) {
            throw new IllegalArgumentException("양의 정수를 입력해 주세요.");
        }
    }

    public int getRoundCount() {
        return roundCount;
    }
}
