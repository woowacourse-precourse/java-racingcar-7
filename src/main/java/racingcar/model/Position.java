package racingcar.model;

public class Position {
    private final int position;

    public Position(final int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Position)) {
            return false;
        }
        Position position = (Position) object;
        return this.position == position.position;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(position);
    }
}