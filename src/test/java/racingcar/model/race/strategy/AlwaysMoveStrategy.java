package racingcar.model.race.strategy;

public class AlwaysMoveStrategy implements MoveStrategy {

    @Override
    public boolean canMove() {
        return true;
    }
}
