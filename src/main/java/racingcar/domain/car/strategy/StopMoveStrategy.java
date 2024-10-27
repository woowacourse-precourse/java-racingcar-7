package racingcar.domain.car.strategy;

public class StopMoveStrategy implements MoveStrategy {

    @Override
    public long move(long position) {
        return position;
    }
}
