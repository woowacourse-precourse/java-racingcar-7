package racingcar.model;

public class RacingCar {

    private final String name;
    private final int position;
    private final int DEFAULT_POSITION = 0;

    public RacingCar(String name) {
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
