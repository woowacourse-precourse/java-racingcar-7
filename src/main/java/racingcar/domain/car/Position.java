package racingcar.domain.car;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final Position ZERO = new Position(0);
    private static final int FORWARD_DISTANCE = 1;

    private final int value;

    private Position(final int value) {
        this.value = value;
    }

    public static Position zero() {
        return ZERO;
    }

    public static Position from(final int value) {
        return new Position(value);
    }

    public Position moveForward() {
        return from(value + FORWARD_DISTANCE);
    }

    public int value() {
        return value;
    }

    @Override
    public int compareTo(final Position o) {
        return this.value - o.value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position position)) {
            return false;
        }
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Position{" +
                "value=" + value +
                '}';
    }

}
