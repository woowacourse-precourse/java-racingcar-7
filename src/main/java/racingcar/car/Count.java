package racingcar.car;

public class Count {

    private final int count;

    public Count(int count) {
        validateInRange(count);
        this.count = count;
    }

    private void validateInRange(int count) {
        if (count < 1 || count >= 1_000) {
            throw new IllegalArgumentException("경기 횟수는 최소 1번 이상, 최대 1,000번까지만 가능합니다.");
        }
    }
}
