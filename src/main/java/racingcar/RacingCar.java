package racingcar;

public class RacingCar {
    private String name;
    private int moveCount = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
