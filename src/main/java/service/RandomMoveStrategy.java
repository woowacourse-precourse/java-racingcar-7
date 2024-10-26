package service;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_THRESHOLD = 5;
    private final Random random;

    public RandomMoveStrategy() {
        this.random = new Random();
    }

    @Override
    public boolean canMove() {
        return random.nextInt(10) >= MOVE_THRESHOLD;
    }
}
