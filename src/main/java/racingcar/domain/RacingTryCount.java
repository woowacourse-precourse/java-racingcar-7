package racingcar.domain;

public class RacingTryCount {

    private final int count;

    private RacingTryCount(String input) {
        int count = toIntValue(input);

        if (isNotPositiveValue(count)) {
            throw new IllegalArgumentException("시도할 횟수는 양수여야 합니다.");
        }

        this.count = count;
    }

    public static RacingTryCount from(String tryCount) {
        return new RacingTryCount(tryCount);
    }

    public int getCount() {
        return count;
    }

    private int toIntValue(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자여야 합니다.");
        }
    }

    private boolean isNotPositiveValue(int count) {
        return !(count > 0);
    }
}
