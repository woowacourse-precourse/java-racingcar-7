package racingcar.domain;

import java.util.Objects;

public class Round {
    private static final int FINAL_ROUND_NUMBER = 0;
    private static final int NEXT_ROUND_NUMBER = 1;

    private final int round;

    public Round(int round) {
        this.round = round;
    }

    public Round nextRound() {
        return new Round(round - NEXT_ROUND_NUMBER);
    }

    public boolean isEnd() {
        return round == FINAL_ROUND_NUMBER;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Round round1 = (Round) object;
        return round == round1.round;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(round);
    }
}
