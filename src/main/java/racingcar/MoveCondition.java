package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveCondition {

    public static int getCondition() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
