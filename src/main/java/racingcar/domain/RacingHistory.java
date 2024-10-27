package racingcar.domain;

public class RacingHistory {
    private String name;
    private int distance;

    public RacingHistory(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
