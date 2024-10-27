package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RuleChecker {

    public static boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

}
