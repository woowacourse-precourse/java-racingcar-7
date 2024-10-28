package racingcar.model.car;

public class AlwaysMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove() {
        return true;
    }
}
