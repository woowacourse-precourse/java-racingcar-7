package racingcar.model;

public class AttemptCount {
    private static final int MIN_ATTEMPT_COUNT = 0;

    private int count;

    public AttemptCount(int count) {
        this.count = count;
    }

    public void decrease() {
        count--;
    }
}
