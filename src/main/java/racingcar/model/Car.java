package racingcar.model;

import static racingcar.util.ConstNumber.PRIME_CAR_DISTANCE;

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
}
