package racingcar.game.model;

public class Counter {
    private static final int INCREASE_VALUE = 1;
    private int count = 0;

    public void increase() {
        count += INCREASE_VALUE;
    }

    public boolean matchesCount(int count) {
        return this.count == count;
    }

    public int getCount() {
        return count;
    }
}