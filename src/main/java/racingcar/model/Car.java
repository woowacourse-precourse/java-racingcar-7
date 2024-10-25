package racingcar.model;

public class Car {
    private String name;
    private int distance;

    public Car(final String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void moveForward() {
        distance += 1;
    }
}
