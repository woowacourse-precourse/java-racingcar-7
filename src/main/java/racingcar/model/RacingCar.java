package racingcar.model;

public class RacingCar {
    private final String name;
    private int movingCount;

    public RacingCar(String name) {
        this.name = name;
        this.movingCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMovingCount() {
        return movingCount;
    }

    public void move() {
        this.movingCount++;
    }
}
