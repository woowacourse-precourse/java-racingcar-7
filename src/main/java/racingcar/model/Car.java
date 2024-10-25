package racingcar.model;

public class Car {
    private final String name;
    private int distance;

    Car(String name) {
        this.name = name;
        distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void addDistance(int distance) {
        this.distance += distance;
    }
}
