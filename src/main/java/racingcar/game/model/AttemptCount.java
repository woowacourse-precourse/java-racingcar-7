package racingcar.game.model;

public class AttemptCount {
    private static final int MIN_INCLUSIVE = 0;
    private int count;

    public AttemptCount(int count) {
        this.count = count;
    }

    public boolean isRemain() {
        return this.count > MIN_INCLUSIVE;
    }

    public void decrease() {
        if (isRemain()) {
            this.count--;
        }
    }
}
