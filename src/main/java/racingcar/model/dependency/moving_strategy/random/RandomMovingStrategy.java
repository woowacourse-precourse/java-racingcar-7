package racingcar.model.dependency.moving_strategy.random;

import racingcar.model.dependency.moving_strategy.MovingStrategy;

public interface RandomMovingStrategy extends MovingStrategy {

    Object generateRandomValue();
}
