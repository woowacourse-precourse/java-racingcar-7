package racingcar.dto;

public class CarStatus {
    private final String name;
    private final int distance;

    public CarStatus(String name, int distance) {
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