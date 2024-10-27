package racingcar.model;

import racingcar.util.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean canMove() {
        int randomValue = RandomNumberGenerator.generate(MIN, MAX);

        return randomValue >= MOVE_THRESHOLD;
    }

}
