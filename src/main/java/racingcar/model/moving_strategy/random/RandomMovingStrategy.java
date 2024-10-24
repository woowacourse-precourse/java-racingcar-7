package racingcar.model.moving_strategy.random;

import racingcar.model.moving_strategy.MovingStrategy;

public interface RandomMovingStrategy extends MovingStrategy {

    Object generateRandomValue();
}
