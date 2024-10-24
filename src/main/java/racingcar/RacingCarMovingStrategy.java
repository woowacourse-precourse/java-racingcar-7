package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarMovingStrategy implements MovingStrategy {

    public static final int RANDOM_NUMBER_START_INCLUSIVE = 0;
    public static final int RANDOM_NUMBER_END_INCLUSIVE = 9;

    @Override
    public boolean canMove() {
        int randomValue = Randoms.pickNumberInRange(RANDOM_NUMBER_START_INCLUSIVE, RANDOM_NUMBER_END_INCLUSIVE);
        return randomValue >= 4;
    }
}
