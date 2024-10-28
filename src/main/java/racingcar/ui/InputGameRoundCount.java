package racingcar.ui;

import java.util.Objects;
import racingcar.domain.Round;

public class InputGameRoundCount {

    private final String roundCount;

    InputGameRoundCount(final String roundCount) {
        validateMinus(roundCount);
        this.roundCount = roundCount;
    }

    public Round getRound() {
        return new Round(this.roundCount);
    }

    private static void validateMinus(final String roundCount) {
        if (roundCount.startsWith("-")) {
            throw new IllegalArgumentException("라운드는 음수 불가");
        }
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final InputGameRoundCount targetInputGameRoundCount = (InputGameRoundCount) object;
        return Objects.equals(roundCount, targetInputGameRoundCount.roundCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundCount);
    }
}
