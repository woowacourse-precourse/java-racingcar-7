package racingcar.car;

import java.util.Objects;

public abstract class Car {

    protected final String name;
    protected int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    abstract public void move();

    abstract public boolean isWinner(int maxPosition);

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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
