package racingcar.model;

public class Car {
    private final String name;
    private int distance;

    protected Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move() {
        distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
