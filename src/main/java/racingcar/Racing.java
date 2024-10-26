package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Racing {
    public boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) > 3;
    }
}
