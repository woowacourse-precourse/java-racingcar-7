package racingcar.domain.strategy;

public class AlwaysStopStrategy implements MoveStrategy {

    @Override
    public boolean isMovable() {
        return false;
    }

}
