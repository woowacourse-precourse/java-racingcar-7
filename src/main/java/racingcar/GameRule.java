package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class GameRule {
    private static final int MOVE_THRESHOLD = 4;

    public static boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD;
    }
}
