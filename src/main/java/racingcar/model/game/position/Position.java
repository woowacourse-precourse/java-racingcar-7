package racingcar.model.game.position;

import java.util.Objects;

public class Position {

    private long position;

    public Position(final long position) {
        this.position = position;
    }

    public void increase() {
        position++;
    }

    public boolean is(final long value) {
        return this.position == value;
    }

    public long position() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position other = (Position) o;
        return position == other.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
