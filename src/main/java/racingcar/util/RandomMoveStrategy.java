package racingcar.util;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_THRESHOLD = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomMoveStrategy(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public boolean isMovable() {
        int randomNumber = randomNumberGenerator.generateNumber();
        return randomNumber >= MOVE_THRESHOLD;
    }
}
