package racingcar;

public class Car {

    private static final String DISTANCE_FORMAT = "-";
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

    @Override
    public String toString() {
        return name + " : " + DISTANCE_FORMAT.repeat(distance);
    }
}
