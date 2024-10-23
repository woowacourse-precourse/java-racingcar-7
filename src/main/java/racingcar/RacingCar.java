package racingcar;

public class RacingCar {

    private final String id;
    private int distance = 0;

    public RacingCar(String id) {
        this.id = id;
    }

    public void moveForward() {
        this.distance++;
    }

    @Override
    public String toString() {
        return id + " : " + "-".repeat(distance);
    }
}
