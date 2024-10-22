package racingcar.domain;

public class MoveCount {
    private int moveCount;

    public MoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public boolean canMove() {
        return moveCount > 0;
    }

    public void decreaseCount() {
        moveCount--;
    }
}
