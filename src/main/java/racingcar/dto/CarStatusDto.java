package racingcar.dto;

public class CarStatusDto {

    private final String name;
    private final int distance;

    public CarStatusDto(String name, int distance) {
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
