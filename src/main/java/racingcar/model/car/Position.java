package racingcar.model.car;

public class Position {
    private static final String ONE_STEP = "-";
    private final StringBuilder distance;

    Position() {
        this.distance = new StringBuilder();
    }

    void increasePosition() {
        distance.append(ONE_STEP);
    }

    public int calculateMovingDistance() {
        return distance.toString().length();
    }

    public String getDistance() {
        return distance.toString();
    }
}
