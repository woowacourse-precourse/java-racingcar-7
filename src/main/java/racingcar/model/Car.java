package racingcar.model;

import java.util.Objects;

public class Car {
    private Name name;
    private Position position;

    public Car(final Name name) {
        this.name = name;
        this.position = new Position();
    }

    public void move(boolean isAbleToMove) {
        if (isAbleToMove) {
            position = position.move();
        }
    }

    public boolean hasBiggerPositionThan(Car car) {
        return position.isBiggerOrEqualTo(car.position);
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Car)) {
            return false;
        }
        Car car = (Car) object;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return getString(sb);
    }

    private String getString(StringBuilder sb) {
        return sb.append(name.getValue()).append(" : ") + "-".repeat(position.getValue());
    }
}