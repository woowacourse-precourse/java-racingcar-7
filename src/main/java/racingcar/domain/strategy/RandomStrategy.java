package racingcar.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomStrategy implements Strategy {

    private static final int LOWER_BOUND = 0;
    private static final int MIN_MOVABLE_NUMBER = 4;
    private static final int UPPER_BOUND = 9;

    private Integer fixedMoveNumber;

    @Override
    public int generate() {
        if (fixedMoveNumber != null && fixedMoveNumber < MIN_MOVABLE_NUMBER) {
            return fixedMoveNumber;
        }
        if (fixedMoveNumber != null && fixedMoveNumber >= MIN_MOVABLE_NUMBER) {
            return fixedMoveNumber;
        }
        if (fixedMoveNumber == null && fixedMoveNumber == null) {
            return Randoms.pickNumberInRange(LOWER_BOUND, UPPER_BOUND);
        }
        return Randoms.pickNumberInRange(LOWER_BOUND, UPPER_BOUND);
    }

    private RandomStrategy() {
        this.fixedMoveNumber = null;
    }

    private RandomStrategy(Integer fixedMoveNumber) {
        this.fixedMoveNumber = fixedMoveNumber;
    }

    public static RandomStrategy from() {
        return new RandomStrategy();
    }

    public static RandomStrategy from(Integer fixedMoveNumber) {
        return new RandomStrategy(fixedMoveNumber);
    }
}