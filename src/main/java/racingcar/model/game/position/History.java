package racingcar.model.game.position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class History {

    private final List<Positions> values;

    public History(final List<Positions> values) {
        this.values = new ArrayList<>(values);
    }

    public void add(Positions positions) {
        values.add(positions.deepCopy());
    }

    public List<Positions> values() {
        return Collections.unmodifiableList(values);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        History history = (History) o;
        return Objects.equals(values, history.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
