package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MOVE_STANDARD = 4;
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String POSITION_SIGN = "-";
    private static final String LINE_CHANGE = "\n";

    private final Name name;
    private int position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, int position) {
        this(new Name(name), position);
    }

    public Car(final Name name, int position) {
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
        return name.toString();
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
        return name.toString() + NAME_POSITION_SEPARATOR + POSITION_SIGN.repeat(position) + LINE_CHANGE;
    }

}
