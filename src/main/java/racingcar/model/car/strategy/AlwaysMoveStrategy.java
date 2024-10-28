package racingcar.model.car.strategy;

public class AlwaysMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove() {
        return true;
    }
}
