package racingcar.domain;

public class RoundCount {
    private static final int END_COUNT = 0;
    private int count;

    public RoundCount(int count) {
        this.count = count;
    }

    public void minusCount() {
        count--;
    }

    public boolean isEnd() {
        return count == END_COUNT;
    }
}
