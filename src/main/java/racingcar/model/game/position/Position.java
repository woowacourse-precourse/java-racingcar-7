package racingcar.model.game.position;

import java.util.Objects;

public class Position {

    private static final int ZERO = 0;

    private long value;

    public Position(final long value) {
        this.value = value;
    }

    public static Position zero() {
        return new Position(ZERO);
    }

    public Position deepCopy() {
        return new Position(value);
    }

    public void increase() {
        value++;
    }

    public boolean isValue(final long value) {
        return this.value == value;
    }

    public long value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
