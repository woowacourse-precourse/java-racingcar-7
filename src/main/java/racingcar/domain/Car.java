package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, int position) {
        validateLength(name);
        this.name = name;
        this.position = position;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다");
        }
    }

    public Car move(int random) {
        if (random >= 4) {
            return new Car(name, position + 1);
        }
        return this;
    }

    public int comparePosition(int max) {
        return Math.max(max, position);
    }

    public boolean isSameForward(int max) {
        return position == max;
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

}
