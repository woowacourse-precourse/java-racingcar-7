package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveDecision {
    public static boolean byRandom() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
