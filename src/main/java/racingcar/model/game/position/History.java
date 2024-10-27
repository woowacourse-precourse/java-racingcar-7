package racingcar.model.game.position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class History {

    private final List<Positions> history;

    public History(final List<Positions> history) {
        this.history = new ArrayList<>(history);
    }

    public void add(Positions positions) {
        history.add(positions.copy());
    }

    public List<Positions> history() {
        return Collections.unmodifiableList(history);
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
