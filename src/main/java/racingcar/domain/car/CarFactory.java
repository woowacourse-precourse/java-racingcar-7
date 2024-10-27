package racingcar.domain.car;

import racingcar.domain.car.strategy.FixedMoveStrategy;
import racingcar.domain.car.strategy.RandomMoveStrategy;
import racingcar.domain.car.strategy.StopMoveStrategy;

public class CarFactory {

    private static final RandomMoveStrategy RANDOM_MOVE_STRATEGY = new RandomMoveStrategy();
    private static final FixedMoveStrategy FIXED_MOVE_STRATEGY = new FixedMoveStrategy();
    private static final StopMoveStrategy STOP_MOVE_STRATEGY = new StopMoveStrategy();

    public static Car create(String name, CarType carType) {
        return switch (carType) {
            case CarType.RANDOM -> new Car(name, RANDOM_MOVE_STRATEGY);
            case CarType.REGULAR -> new Car(name, FIXED_MOVE_STRATEGY);
            case CarType.NEVER_MOVE -> new Car(name, STOP_MOVE_STRATEGY);
            default -> null;
        };
    }
}
