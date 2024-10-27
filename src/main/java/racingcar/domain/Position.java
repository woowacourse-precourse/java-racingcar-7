package racingcar.domain;

import java.util.Objects;

public class Position {

    private static final Position DEFAULT_POSITION = new Position(0);

    private final int position;

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 음수 일 수 없습니다.");
        }
        this.position = position;
    }

    public static Position defaultInstance() {
        return DEFAULT_POSITION;
    }

    public Position increase() {
        return new Position(this.position + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
