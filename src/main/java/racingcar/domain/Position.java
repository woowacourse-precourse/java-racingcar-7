package racingcar.domain;

import java.util.Objects;

public class Position {
    public static final int DEFAULT_POSITION = 0;
    private static final int MOVE_COUNT = 1;

    private final int position;

    public Position() {
        this.position = DEFAULT_POSITION;
    }

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Position move() {
        return new Position(this.position + MOVE_COUNT);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Position position1 = (Position) object;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }
}
