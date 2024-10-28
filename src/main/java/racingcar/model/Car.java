package racingcar.model;

import java.util.Objects;

public class Car {

    private int position = 0;
    private final String name;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이내여야 합니다.");
        }
        this.name = name;
    }

    public Car(Car car) {
        this.position = car.position;
        this.name = car.name;
    }

    public void move(int distance) {
        this.position += distance;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car car)) {
            return false;
        }
        return Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
