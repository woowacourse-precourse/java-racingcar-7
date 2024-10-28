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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
