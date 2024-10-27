package racingcar.domain;

import java.util.Comparator;

class Round implements Comparator<Round> {
    private final int round;

    public Round(final int round) {
        this.round = round;
    }
    
    @Override
    public int compare(Round o1, Round o2) {
        return o1.round - o2.round;
    }
}
