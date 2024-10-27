package racingcar.vo;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final int INITIAL_POSITION = 0;
    private final int value;

    private Position(int value) {
        this.value = value;
    }

    public static Position initial() {
        return new Position(INITIAL_POSITION);
    }

    public Position forward() {
        return new Position(value + 1);
    }
    
    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position other)) {
            return false;
        }
        return value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
