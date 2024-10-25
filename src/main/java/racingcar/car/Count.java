package racingcar.car;

public class Count {

    public static final int MIN_COUNT = 1;
    public static final int MAX_COUNT = 1_000;
    private final int count;

    public Count(int count) {
        validateInRange(count);
        this.count = count;
    }

    public int getValue() {
        return count;
    }

    private void validateInRange(int count) {
        if (count < MIN_COUNT || count >= MAX_COUNT) {
            throw new IllegalArgumentException("경기 횟수는 최소 1번 이상, 최대 1,000번까지만 가능합니다.");
        }
    }
}
