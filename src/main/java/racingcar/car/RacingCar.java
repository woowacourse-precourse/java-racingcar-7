package racingcar.car;

public class RacingCar {
    private final String name;
    private int moveCount;

    public RacingCar(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public void increaseMoveCount() {
        moveCount += 1;
    }

    public boolean isWinner(int maxMoveCount) {
        return moveCount == maxMoveCount;
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
