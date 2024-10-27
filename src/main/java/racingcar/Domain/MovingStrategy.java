package racingcar.Domain;

import camp.nextstep.edu.missionutils.Randoms;

public class MovingStrategy {
    private static final int FORWARD_THRESHOLD = 4;
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public static boolean canMove() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER) >= FORWARD_THRESHOLD;
    }
}
