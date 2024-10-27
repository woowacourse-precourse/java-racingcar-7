package racingcar.strategy;

import racingcar.util.RandomUtil;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean canMove() {
        return RandomUtil.getRandomNumberInRange(0, 9) >= 4;
    }
}
