package racingcar.ui;

import java.util.Objects;

public class InputGameRoundCount {

    private final String roundCount;

    InputGameRoundCount(final String roundCount) {
        this.roundCount = roundCount;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        InputGameRoundCount that = (InputGameRoundCount) object;
        return Objects.equals(roundCount, that.roundCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundCount);
    }
}
