package racingcar.domain.car.strategy;

public class FixedMoveStrategy implements MoveStrategy {
    private static final Long MOVE_STEP = 1L;

    @Override
    public long move(long position) {
        return position + MOVE_STEP;
    }
}
