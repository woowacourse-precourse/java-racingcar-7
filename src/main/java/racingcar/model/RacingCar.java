package racingcar.model;

public class RacingCar {

    private static final int MOVING_FORWARD = 4;

    private final String name;
    private Integer position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public Integer move(Integer randomNumber) {
        if (randomNumber >= MOVING_FORWARD) {
            position++;
        }
        return position;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}
