package racingcar.domain.race;

public class CarSnapshot {
    private final String name;
    private final Integer position;

    public CarSnapshot(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}