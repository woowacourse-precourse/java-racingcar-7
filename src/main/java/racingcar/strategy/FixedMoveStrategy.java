package racingcar.strategy;

public class FixedMoveStrategy implements MoveStrategy {

    private final boolean canMove;

    public FixedMoveStrategy(boolean canMove) {
        this.canMove = canMove;
    }

    @Override
    public boolean canMove() {
        return canMove;
    }
}
