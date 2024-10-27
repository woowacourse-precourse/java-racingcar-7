package racingcar.model;

public class Position {
    private static final int DEFAULT_POSITION = 0;
    private static final int DEFAULT_MOVEMENT_AMOUNT = 1;

    private final int value;

    public Position() {
        this.value = DEFAULT_POSITION;
    }

    public Position(final int value) {
        this.value = value;
    }

    public Position move() {
        return new Position(value + DEFAULT_MOVEMENT_AMOUNT);
    }

    public boolean isBiggerOrEqualTo(final Position position) {
        return this.value >= position.value;
    }

    public int getValue() {
        return value;
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
        return this.value == position.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}