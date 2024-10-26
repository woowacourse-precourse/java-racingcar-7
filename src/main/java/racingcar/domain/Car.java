package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MOVE_STANDARD = 4;
    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String POSITION_SIGN = "-";
    private static final String LINE_CHANGE = "\n";

    private final String name;
    private int position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validateNameLength(name);
        this.name = name;
        this.position = position;
    }

    public void validateNameLength(String name) {
        int nameLength = name.length();

        if (nameLength < MINIMUM_NAME_LENGTH || nameLength > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다");
        }
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
        return name + NAME_POSITION_SEPARATOR + POSITION_SIGN.repeat(position) + LINE_CHANGE;
    }
}
