package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class MovementProvider {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MOVEMENT_THRESHOLD = 4;

    public static boolean canMove() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        return randomNumber >= MOVEMENT_THRESHOLD;
    }
}
