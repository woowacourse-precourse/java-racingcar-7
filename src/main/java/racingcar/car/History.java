package racingcar.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class History {

    private final List<Positions> value;

    public History(final List<Positions> value) {
        this.value = new ArrayList<>(value);
    }

    public void add(Positions positions) {
        value.add(positions.deepCopy());
    }

    public List<Positions> value() {
        return Collections.unmodifiableList(value);
    }
}
