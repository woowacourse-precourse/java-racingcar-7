package racingcar.model;

public class Distance {
    private static final Integer START_DISTANCE = 0;
    private Integer distance;

    public Distance() {
        this.distance = START_DISTANCE;
    }
    public Integer getDistance() {
        return distance;
    }

    public void increase() {
        this.distance += 1;
    }

}
