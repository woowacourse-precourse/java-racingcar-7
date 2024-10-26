package racingcar.car;

public class Car {

    private static final String DISTANCE_FORMAT = "-";

    private final CarName name;
    private int distance;

    public Car(final CarName name) {
        this.name = name;
        this.distance = 0;
    }

    public Car(final CarName name, final int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void forward() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }

    public CarName getName() {
        return name;
    }

    @Override
    public String toString() {
        return name.getContent() + " : " + DISTANCE_FORMAT.repeat(distance);
    }
}
