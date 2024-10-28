package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumManager {
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;
    private static final int MOVE_FORWARD_CONDITION = 4;

    public static boolean isSatisfyForwardCondition(int number) {
        return number > MOVE_FORWARD_CONDITION;
    }

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(LOWER_BOUND, UPPER_BOUND);
    }

}
