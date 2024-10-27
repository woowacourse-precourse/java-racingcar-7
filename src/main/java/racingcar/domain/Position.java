package racingcar.domain;

import java.util.Objects;

public class Position {

    private static final String POSITION_SIGN = "-";

    private int number;

    public Position(int number) {
        this.number = number;
    }

    public int getLargerPosition(int position) {
        return Math.max(number, position);
    }

    public boolean isSamePosition(int position) {
        return number == position;
    }

    public Position move() {
        return new Position(number + 1);
    }

    public String signCount() {
        return POSITION_SIGN.repeat(number);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Position position)) {
            return false;
        }
        return number == position.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

}
