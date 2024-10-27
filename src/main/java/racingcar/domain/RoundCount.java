package racingcar.domain;

public class RoundCount {

    private final int count;

    public RoundCount(int count) {
        validate(count);

        this.count = count;
    }

    private void validate(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수이어야 합니다");
        }
    }

    public int getCount() {
        return count;
    }
}
