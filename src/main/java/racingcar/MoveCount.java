package racingcar;

public class MoveCount {
    private final int moveCount;

    public MoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public MoveCount add() {
        return new MoveCount(moveCount + 1);
    }
}
