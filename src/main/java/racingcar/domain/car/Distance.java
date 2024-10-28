package racingcar.domain.car;

public class Distance {
    private Integer distance;

    public Distance(Integer distance) {
        this.distance = distance;
    }

    public static Distance createStartLine() {
        return new Distance(0);
    }

    public void addDistance() {
        this.distance++;
    }

    public Integer getDistance() {
        return distance;
    }
}
