package racingcar.domain;

import java.util.Objects;

public class Position {
    private static final int FORWARD_COUNT = 1;
    private static final int INIT_POSITION_VALUE = 0;
    private static final int COMPARE_RESULT_EQUAL_VALUE = 0;
    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position create() {
        return new Position(INIT_POSITION_VALUE);
    }

    public Position move() {
        return new Position(position + FORWARD_COUNT);
    }

    public boolean isGreater(Position OtherPosition) {
        return this.position - OtherPosition.getPosition() > COMPARE_RESULT_EQUAL_VALUE;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
