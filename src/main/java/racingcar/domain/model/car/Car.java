package racingcar.domain.model.car;

public class Car {
    private int distance;
    private final String name;

    private Car(final String name) {
        this.distance = 0;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void moveForward() {
        this.distance++;
    }
}
