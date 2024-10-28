package racingcar.game.model;

public class Counter {
    private static final int INCREMENT_STEP = 1;
    private int count = 0;

    public void increase() {
        count += INCREMENT_STEP;
    }

    public boolean matchesCount(int count) {
        return this.count == count;
    }

    public int getCount() {
        return count;
    }
}