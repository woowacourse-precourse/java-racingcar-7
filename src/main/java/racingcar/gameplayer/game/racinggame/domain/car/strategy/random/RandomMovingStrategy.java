package racingcar.gameplayer.game.racinggame.domain.car.strategy.random;

import racingcar.gameplayer.game.common.domain.PositiveNumber;
import racingcar.gameplayer.game.racinggame.domain.car.Position;

public class RandomMovingStrategy implements MovingStrategy {

    private static final PositiveNumber RANDOM_PIVOT_NUM = new PositiveNumber(4L);
    private final RandomValueGenerator generator;
    private static final RandomValueGenerator DEFAULT_RANDOM_GENERATOR = new PositiveRandomValueGenerator();


    public RandomMovingStrategy() {
        this(DEFAULT_RANDOM_GENERATOR);
    }

    public RandomMovingStrategy(RandomValueGenerator generator) {
        this.generator = generator;
    }

    @Override
    public Position getDistance() {
        if (randomValueInRange()) {
            return Position.ONE;
        }
        return Position.ZERO;
    }

    private boolean randomValueInRange() {
        return generator.generate().greaterThanOrEqualTo(RANDOM_PIVOT_NUM);
    }
}
