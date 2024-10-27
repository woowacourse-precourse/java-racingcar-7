package racingcar.model;

public class Distance {
    private int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public int move(int randomDistance) {
        return this.distance + randomDistance;
    }
}
