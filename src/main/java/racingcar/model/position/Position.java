package racingcar.model.position;

import static racingcar.common.constant.SystemConstant.EMPTY_STRING;

import java.util.Objects;

public class Position {
    private final String value;

    private Position() {
        this.value = EMPTY_STRING;
    }

    private Position(final String value) {
        this.value = value;
    }

    public static Position initiate() {
        return new Position();
    }

    public static Position from(String source) {
        return new Position(source);
    }

    public Position add(final Distance distance) {
        Distance destination = currentDistance().add(distance);
        return PositionBuilder.from(destination);
    }

    private Distance currentDistance() {
        return Distance.from(value.length());
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position oPosition = (Position) obj;
        return Objects.equals(this.value, oPosition.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
