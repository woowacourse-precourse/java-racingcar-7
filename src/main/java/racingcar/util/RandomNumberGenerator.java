package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int RANDOM_START_INCLUSIVE = 0;
    private static final int RANDOM_END_INCLUSIVE = 9;
    private static final int MOVE_THRESHOLD = 4;

    public static boolean shouldMove() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
        return randomNumber >= MOVE_THRESHOLD;
    }
}