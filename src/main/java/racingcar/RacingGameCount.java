package racingcar;

public class RacingGameCount {
    private final int tryCount;

    public RacingGameCount(String tryCount) {
        this.tryCount = validateTryCount(tryCount);
    }

    private int validateTryCount(String tryCount) {
        try {
            int number = Integer.parseInt(tryCount);
            if (number <= 0) {
                throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        }
    }

    public int getTryCountValue() {
        return tryCount;
    }
}
