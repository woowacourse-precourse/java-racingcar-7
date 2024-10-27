package racingcar;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void goForward() {
        distance++;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}