package racingcar.model;

public class RacingCar {

    private final String name;
    private int moveCount;

    private RacingCar(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public void move() {
        moveCount++;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public static RacingCar from(String name) {
        return new RacingCar(name);
    }
}
