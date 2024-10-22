package racingcar;

import java.util.SplittableRandom;

public class RacingCar {
    private String name;
    private int moveCount;

    public RacingCar(String name, int moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public void increaseMoveCount() {
        moveCount += 1;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public boolean isFinish(int finishCount) {
        return moveCount >= finishCount;
    }

    public String getProgress() {
        return "-".repeat(moveCount);
    }
}
