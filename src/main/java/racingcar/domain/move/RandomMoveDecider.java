package racingcar.domain.move;


import racingcar.randomGenerator.RandomNumberGenerator;

public class RandomMoveDecider implements MoveDecider {
    private static final int MOVE_THRESHOLD = 4;
    private final RandomNumberGenerator randomNumberGenerator;

    public RandomMoveDecider(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public boolean canMove() {
        return randomNumberGenerator.generate() >= MOVE_THRESHOLD;
    }
}
