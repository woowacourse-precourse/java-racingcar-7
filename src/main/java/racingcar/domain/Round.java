package racingcar.domain;

import java.time.LocalDateTime;
import java.util.Objects;

class Round implements Comparable<Round> {

    private final int round;
    private final LocalDateTime startTime;

    public Round(final int round) {
        this.round = round;
        this.startTime = LocalDateTime.now();
    }

    public Round nextRound() {
        return new Round(this.round + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Round round1 = (Round) o;
        return round == round1.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }

    @Override
    public int compareTo(Round o) {
        return this.round - o.round;
    }
}
