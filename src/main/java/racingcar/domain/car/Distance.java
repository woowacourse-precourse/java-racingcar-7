package racingcar.domain.car;

public class Distance {
    private Integer distance;

    public Distance(Integer distance) {
        this.distance = distance;
    }

    public static Distance createStartLine() {
        return new Distance(0);
    }

    public Integer getDistance() {
        return distance;
    }
}
