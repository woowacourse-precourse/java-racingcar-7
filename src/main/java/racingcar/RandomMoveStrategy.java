package racingcar;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_THRESHOLD = 4;
    private final RandomGenerator randomGenerator;

    public RandomMoveStrategy(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public boolean isMovable() {
        return randomGenerator.generate() >= MOVE_THRESHOLD;
    }
}
