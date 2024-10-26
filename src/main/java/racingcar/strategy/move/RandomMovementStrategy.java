package racingcar.strategy.move;

import java.util.Random;

public class RandomMovementStrategy implements MovementStrategy {
    private final Random random;

    public RandomMovementStrategy() {
        this.random = new Random();
    }

    @Override
    public boolean shouldMove() {
        return random.nextInt(10) >= 4; // 4 이상일 때만 전진
    }
}