package racingcar.vo;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final int INITIAL_POSITION = 0;
    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position initial() {
        return new Position(INITIAL_POSITION);
    }

    public Position forward() {
        return new Position(position + 1);
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(this.position, other.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Position other)) {
            return false;
        }
        return position == other.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }
}
