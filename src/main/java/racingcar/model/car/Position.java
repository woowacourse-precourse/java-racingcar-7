package racingcar.model.car;

public class Position {
    private static final String ONE_STEP = "_";
    private final StringBuilder distance;

    protected Position() {
        this.distance = new StringBuilder();
    }

    protected int calculateMovingDistance() {
        return distance.toString().length();
    }

    public String getDistance() {
        return distance.toString();
    }
}
