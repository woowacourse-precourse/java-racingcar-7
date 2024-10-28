package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveStrategy {
    public static boolean randomMoveStrategy(){
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
