package racingcar.domain.movement;

import static racingcar.constant.GameConstants.THRESHOLD;

import racingcar.domain.game.NumberGenerator;

public class RandomMovementStrategy implements MovementStrategy {
    private final NumberGenerator numberGenerator;

    public RandomMovementStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean shouldMove() {
        return numberGenerator.generate() >= THRESHOLD;
    }

}
