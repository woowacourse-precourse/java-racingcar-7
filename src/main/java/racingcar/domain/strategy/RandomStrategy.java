package racingcar.domain.strategy;

import static racingcar.domain.strategy.Movement.MOVE;
import static racingcar.domain.strategy.Movement.RANDOM;
import static racingcar.domain.strategy.Movement.STOP;

public class RandomStrategy implements Strategy {

    private Movement movement;

    @Override
    public int generate() {
        switch (movement) {
            case STOP:
                return STOP.value;
            case MOVE:
                return MOVE.value;
            default:
                RANDOM:
                return RANDOM.value;
        }
    }

    private RandomStrategy(Movement movement) {
        this.movement = movement;
    }

    public static RandomStrategy from(Movement movement) {
        return new RandomStrategy(movement);
    }
}
