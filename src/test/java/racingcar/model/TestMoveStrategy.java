package racingcar.model;

class TestMoveStrategy implements MoveStrategy {

    private final boolean canMove;

    public TestMoveStrategy() {
        this.canMove = true;
    }

    public TestMoveStrategy(boolean canMove) {
        this.canMove = canMove;
    }

    @Override
    public boolean canMove() {
        return canMove;
    }

}
