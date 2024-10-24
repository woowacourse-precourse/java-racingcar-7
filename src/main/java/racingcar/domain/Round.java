package racingcar.domain;

import java.util.Iterator;

public class Round implements Iterator {
    private final int total;
    private int current;

    public Round(int total) {
        this.total = total;
        this.current = 1;
    }

    @Override
    public boolean hasNext() {
        return current < total;
    }

    @Override
    public Object next() {
        return ++current;
    }
}
