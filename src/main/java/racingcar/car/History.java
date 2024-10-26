package racingcar.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
}
