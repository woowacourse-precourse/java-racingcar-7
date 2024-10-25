package racingcar.domain;

public class RacingCar {
    private static final int MOVE_DISTANCE = 1;

    private String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void moveForward() {
        this.distance += MOVE_DISTANCE;
    }
}
