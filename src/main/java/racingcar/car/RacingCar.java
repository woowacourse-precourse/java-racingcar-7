package racingcar.car;

public class RacingCar {
    private final String name;
    private int moveCount;

    private RacingCar(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public static RacingCar of(String name) {
        return new RacingCar(name, 0);
    }

    public void increaseMoveCount() {
        moveCount += 1;
    }

    public boolean isMoveCountEqualTo(int count) {
        return moveCount == count;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getProgress() {
        return "-".repeat(moveCount);
    }
}
