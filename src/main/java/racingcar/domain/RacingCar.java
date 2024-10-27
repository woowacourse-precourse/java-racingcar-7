package racingcar.domain;

public class RacingCar {
    private static final int MOVE_DISTANCE = 1;
    private static final int START_POINT = 0;

    private String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = START_POINT;
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
