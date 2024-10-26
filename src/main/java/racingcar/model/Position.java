package racingcar.model;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private static final int DEFAULT_POSITION = 0;
    private static final int MOVEMENT_DISTANCE = 1;

    private int value;

    private Position(int value) {
        this.value = value;
    }

    public static Position defaultValue() {
        return new Position(DEFAULT_POSITION);
    }

    public void moveForward() {
        value += MOVEMENT_DISTANCE;
    }

    public int value() {
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
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Position position) {
        return Integer.compare(this.value, position.value);
    }
}