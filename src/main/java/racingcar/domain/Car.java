package racingcar.domain;

public class Car {
    private final String name;
    private int distance;
    private static final Integer INITIAL_POINT = 0;

    public Car(String name) {
        this.name = name;
        this.distance = INITIAL_POINT;
    }

    public void moveForward() {
        this.distance += 1;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
