package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MOVE_STANDARD = 4;
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String POSITION_SIGN = "-";

    private final String name;
    private int position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car move(int random) {
        if (random >= MOVE_STANDARD) {
            position += 1;
            return new Car(name, position);
        }
        return this;
    }

    public int getLargerMove(int move) {
        return Math.max(position, move);
    }

    public boolean isSameMaxMove(int maxMove) {
        return position == maxMove;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Car car)) {
            return false;
        }
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + NAME_POSITION_SEPARATOR + POSITION_SIGN.repeat(position);
    }
}
