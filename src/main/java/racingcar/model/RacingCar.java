package racingcar.model;

public class RacingCar {
    public static final String HYPHEN = "-";

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

    public String getMovingResult() {
        return HYPHEN.repeat(movingCount);
    }
}
