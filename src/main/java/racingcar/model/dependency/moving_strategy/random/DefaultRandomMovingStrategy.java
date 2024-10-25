package racingcar.model.dependency.moving_strategy.random;

import racingcar.util.ramdom.RandomRange;
import racingcar.util.ramdom.RandomUtils;

public class DefaultRandomMovingStrategy implements RandomMovingStrategy {

    public final int DEFAULT_RANDOM_RANGE_MIN = 0;
    public final int DEFAULT_RANDOM_RANGE_MAX = 9;
    public final int MIN_MOVEABLE_NUMBER = 4;

    @Override
    public boolean isMovable() {
        return generateRandomValue() >= MIN_MOVEABLE_NUMBER;
    }

    @Override
    public Integer generateRandomValue() {
        return RandomUtils.generateRandomNumber(new RandomRange(DEFAULT_RANDOM_RANGE_MIN, DEFAULT_RANDOM_RANGE_MAX));
    }
}
