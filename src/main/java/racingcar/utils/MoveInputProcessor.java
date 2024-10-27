package racingcar.utils;

public class MoveInputProcessor {
    private final int moveCount;

    public MoveInputProcessor(String moveCount) {
        this.moveCount = Integer.parseInt(moveCount);
    }

    public void validInput() {

    }

    public int getMoveCount(){
        return moveCount;
    }
}
