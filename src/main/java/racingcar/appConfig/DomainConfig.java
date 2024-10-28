package racingcar.appConfig;

import racingcar.domain.game.NumberGenerator;
import racingcar.domain.game.RandomNumberGenerator;
import racingcar.domain.movement.MovementPolicy;
import racingcar.domain.movement.MovementStrategy;
import racingcar.domain.movement.RandomMovementStrategy;

public class DomainConfig {
    private final NumberGenerator numberGenerator;
    private final MovementStrategy movementStrategy;
    private final MovementPolicy movementPolicy;

    public DomainConfig() {
        this.numberGenerator = new RandomNumberGenerator();
        this.movementStrategy = new RandomMovementStrategy(numberGenerator);
        this.movementPolicy = new MovementPolicy(movementStrategy);
    }

    public MovementPolicy getMovementPolicy() {
        return movementPolicy;
    }
}