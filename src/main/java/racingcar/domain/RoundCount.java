package racingcar.domain;

public class RoundCount {
    private static final int ENDCOUNT = 0;
    private int count;

    public RoundCount(int count) {
        this.count = count;
    }

    public void minusCount() {
        count--;
    }

    public boolean isEnd() {
        return count == ENDCOUNT;
    }
}
