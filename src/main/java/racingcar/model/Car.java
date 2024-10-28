package racingcar.model;

public class Car {

    private static final int START_POSITION = 0;
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = START_POSITION;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
