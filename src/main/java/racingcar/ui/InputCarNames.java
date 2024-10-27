package racingcar.ui;

import java.util.Objects;

public class InputCarNames {

    private final String names;

    InputCarNames(final String names) {
        this.names = names;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        InputCarNames that = (InputCarNames) object;
        return Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
