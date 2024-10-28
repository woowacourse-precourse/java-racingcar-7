package racingcar.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

public class Round {

    private final int maxRound;
    private final int currRound;
    private final LocalDateTime startTime;

    public Round(final String maxRound) {
        this.maxRound = getMaxRound(maxRound);
        this.currRound = 0;
        this.startTime = LocalDateTime.now();4
    }

    private static int getMaxRound(final String inputRound) {
        try {
            return Integer.parseInt(inputRound);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 라운드 수 입력");
        }
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
        return currRound == round1.currRound;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxRound, currRound);
    }
}
