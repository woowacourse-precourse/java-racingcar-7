package racingcar.domain.car;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private final int value;

    private Position(int value) {
        this.value = value;
    }

    public static Position from(int value) {
        return new Position(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return getValue() == position.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(this.value, other.value);
    }
}
