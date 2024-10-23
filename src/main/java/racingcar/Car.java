package racingcar;

public class Car {

    private final String name;
    private int distance;

    public Car(final String name) {
        this.name = name;
        this.distance = 0;
    }

    public void forward() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }
}
