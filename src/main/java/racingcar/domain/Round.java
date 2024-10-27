package racingcar.domain;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Round implements Iterator<Integer> {
    static final int MIN_TOTAL = 1;
    private final int total;
    private int current;

    public Round(int total) {
        validateTotalRound(total);
        this.total = total;
        this.current = 0;
    }

    public int getCurrent() {
        return current;
    }

    @Override
    public boolean hasNext() {
        return current < total;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return ++current;
    }

    private void validateTotalRound(int total) {
        if (total < MIN_TOTAL) {
            throw new IllegalArgumentException();
        }
    }
}
