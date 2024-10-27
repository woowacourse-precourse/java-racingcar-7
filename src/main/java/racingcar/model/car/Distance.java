package racingcar.model.car;

public class Distance {

    private final String distanceShape = "-";

    private final StringBuilder distance;

    public Distance() {
        distance = new StringBuilder();
    }

    public void increaseDistance() {
        distance.append(distanceShape);
    }

    public void resetDistance() {
        distance.setLength(0);
    }

    public String toString() {
        return distance.toString();
    }

}
