package racingcar.domain.car;

public class Distance {
    private int distance;

    public Distance(int distance) {
        this.distance = distance;
    }

    public void moveForward() {
        this.distance++;
    }

    public int getDistance() {
        return distance;
    }
}
