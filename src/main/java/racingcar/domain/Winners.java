package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Winners {

    private final List<ProgressedInformation> winners;

    public Winners(final List<ProgressedInformation> winners) {
        this.winners = winners;
    }

    public List<ProgressedInformation> getWinners() {
        return Collections.unmodifiableList(winners);
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final Winners targetWinners = (Winners) object;
        return Objects.equals(winners, targetWinners.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
