package racingcar.model.game.position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class History {

    private final List<List<Long>> history;

    public History() {
        this.history = new ArrayList<>();
    }

    public void add(Positions positions) {
        history.add(positions.values());
    }

    public List<Long> at(int round) {
        return Collections.unmodifiableList(history.get(round));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        History other = (History) o;
        return Objects.equals(history, other.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(history);
    }
}
