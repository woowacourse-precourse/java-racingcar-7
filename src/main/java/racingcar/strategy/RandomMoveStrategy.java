package racingcar.strategy;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_THRESHOLD = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final RandomNumberGenerator randomNumberGenerator;

    public RandomMoveStrategy(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public boolean shouldMove() {
        int randomNumber = randomNumberGenerator.generate(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        return randomNumber >= MOVE_THRESHOLD;
    }
}
