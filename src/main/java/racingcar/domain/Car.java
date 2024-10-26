package racingcar.domain;

import java.util.Objects;

public class Car {

    private final int MOVE_STANDARD = 4;

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
