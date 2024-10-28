package racingcar.model.game.round;

import java.util.Objects;
import racingcar.exception.InvalidRoundException;

public class Round {

    private final long round;

    public Round(final long round) {
        validate(round);
        this.round = round;
    }

    private void validate(final long round) {
        if (round < 0) {
            throw new InvalidRoundException("시도할 횟수는 0 또는 양수여야 합니다.");
        }
    }

    public long round() {
        return round;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Round other = (Round) o;
        return round == other.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }
}
