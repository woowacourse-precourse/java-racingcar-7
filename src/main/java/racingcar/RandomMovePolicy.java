package racingcar;

public class RandomMovePolicy implements MovePolicy {

    private static final int MOVE_THRESHOLD = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomMovePolicy(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public boolean canMove() {
        int randomValue = randomNumberGenerator.run();
        return randomValue >= MOVE_THRESHOLD;
    }

}
