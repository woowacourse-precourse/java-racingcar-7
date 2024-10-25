package racingcar.model;

import static racingcar.util.RegisterCarNumberConstant.PRIME_CAR_DISTANCE;

import java.util.Objects;

public class Car {

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        distance = PRIME_CAR_DISTANCE.getValue();
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        distance++;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
