package racingcar.model.primitive;

import java.util.Objects;
import racingcar.exception.ErrorMessage;

public class Position {

    private static final int ONE_MOVE = 1;
    private static final int MIN_POSITION = 0;

    private int position;

    private Position(int position) {
        validate(position);
        this.position = position;
    }

    public static Position from(int position) {
        return new Position(position);
    }

    private void validate(int position) {
        if (isNegative(position)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_POSITION.getMessage());
        }
    }

    private boolean isNegative(int position) {
        return position < MIN_POSITION;
    }

    public void move() {
        position = position + ONE_MOVE;
    }

    public int calculateMaxPosition(int maxPosition) {
        return Math.max(maxPosition, this.position);
    }

    public boolean isMax(int maxPosition) {
        return this.position == maxPosition;
    }

    public int getPosition() {
        return position;
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
        return Objects.hashCode(position);
    }
}
