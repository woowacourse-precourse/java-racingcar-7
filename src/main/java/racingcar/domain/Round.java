package racingcar.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

public class Round implements Comparable<Round> {

    private final int maxRound;
    private final int currRound;
    private final LocalDateTime startTime;

    public Round(final String maxRound) {
        this.maxRound = Integer.parseInt(maxRound);
        this.currRound = 0;
        this.startTime = LocalDateTime.now();
    }

    private Round(final int maxRound, final int currRound) {
        this.maxRound = maxRound;
        this.currRound = currRound;
        this.startTime = LocalDateTime.now();
    }

    public Optional<Round> nextRound() {
        if (this.maxRound == this.currRound) {
            return Optional.empty();
        }
        return Optional.of(new Round(this.maxRound, currRound + 1));
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
        return maxRound == round1.maxRound;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxRound);
    }

    @Override
    public int compareTo(Round o) {
        return this.maxRound - o.maxRound;
    }
}
