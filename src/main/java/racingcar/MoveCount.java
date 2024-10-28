package racingcar;

public class MoveCount {
    private final int moveCount;

    public MoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public MoveCount add() {
        return new MoveCount(moveCount + 1);
    }

    public void print() {
        for (int i = 0; i<moveCount; i++){
            System.out.print("-");
        }
    }
}
