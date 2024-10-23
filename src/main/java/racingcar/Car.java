package racingcar;

import java.util.Objects;

public class Car {

    private static final int FORWARD_STANDARD = 4;

    private final String name;
    private final int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car move(int random) {
        if (random >= FORWARD_STANDARD) {
            return new Car(name, position + 1);
        }
        return this;
    }

    public int currentPosition() {
        return position;
    }

    public boolean isSameForward(int maxForward) {
        return position == maxForward;
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
