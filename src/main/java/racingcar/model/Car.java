package racingcar.model;

public class Car {
    private final String name;
    private final StringBuilder distance;
    private static final String ONE_STEP = "-";

    public Car(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.distance = new StringBuilder();
    }

    public void advance() {
        distance.append(ONE_STEP);
    }

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance.toString();
    }
}
