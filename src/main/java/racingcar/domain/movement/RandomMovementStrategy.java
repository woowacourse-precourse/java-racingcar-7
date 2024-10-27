package racingcar.domain.movement;

import racingcar.domain.game.NumberGenerator;

public class RandomMovementStrategy implements MovementStrategy {
    private static final int THRESHOLD = 4;
    private final NumberGenerator numberGenerator;

    public RandomMovementStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean shouldMove() {
        return numberGenerator.generate() >= THRESHOLD;
    }

}
