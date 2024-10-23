package racingcar;

public class Car {

    private static final String DISTANCE_FORMAT = "-";

    private final CarName name;
    private int distance;

    public Car(final CarName name) {
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
        return name.getContent() + " : " + DISTANCE_FORMAT.repeat(distance);
    }
}
