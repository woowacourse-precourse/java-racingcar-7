package service;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * Provides strategy for movement decisions using random number generation.
 */
public class MoveStrategy {
    /**
     * Determines whether to move based on a random number.
     * @return true if random number is greater than 3, false otherwise
     */
    public static boolean moveOrNot() {
        int pickNumber = Randoms.pickNumberInRange(0, 9);
        return pickNumber > 3;
    }
}