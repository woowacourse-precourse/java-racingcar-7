package racingcar.domain.strategy;

import java.util.Random;

public class RandomMovableStrategy implements MovableStrategy {
    private static final Random random = new Random();

    @Override
    public boolean shouldMove() {
        return random.nextInt(10) >= 4;
    }
}
